package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.Custom.ClearEditText;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.addtelBean;
import com.example.yuzishun.clearservice.net.ApiMethods;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class AddtelActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.layout_search)
    LinearLayout layout_search;
    @BindView(R.id.name_cltext)
    ClearEditText name_cltext;
    @BindView(R.id.number_cltext)
    ClearEditText number_cltext;
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.tel_cltext)
    ClearEditText tel_text;
    @BindView(R.id.button_cun)
    Button button_cun;
    @Override
    public int intiLayout() {
        return R.layout.activity_addtel;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_text.setText(R.string.add_newtel);
        image_back.setOnClickListener(this);
        layout_search.setOnClickListener(this);
        button_cun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newTel();

            }
        });
    }

    private void newTel() {
        String[] data = new String[]{"121.472517","31.268818"};
        List list =new ArrayList();
        for (int i = 0; i <data.length ; i++) {
            list.add(data[i]);

        }
        String toString = getToString(data);

        Log.e("YZS",list.toString()+"");
        HashMap<String,String> hashMap  = new HashMap<>();
        hashMap.put("user_access_token", Content.Token);
        hashMap.put("address_point",toString+"");
        hashMap.put("address_name",city.getText().toString().trim()+"");
        hashMap.put("address_info",tel_text.getText().toString().trim());
        hashMap.put("address_city","上海");
        hashMap.put("user_name",name_cltext.getText().toString().trim()+"");
        hashMap.put("mobile_phone",number_cltext.getText().toString().trim()+"");

        Observer<addtelBean> observer = new Observer<addtelBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(addtelBean addtelBean) {
                if(addtelBean.getCode()==200){

                    Toast.makeText(AddtelActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                    //数据是使用Intent返回
                    Intent intent = new Intent();
                    int i =1;
                    //把返回数据存入Intent
                    intent.putExtra("result", i);
                    //设置返回数据
                    setResult(RESULT_OK, intent);
                    //关闭Activity
                    finish();
                    finish();
                }

            }

            @Override
            public void onError(Throwable e) {

                Log.e("YZS",e.getMessage());
                Toast.makeText(AddtelActivity.this, "参数有误", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        };

        ApiMethods.getaddtel(observer,hashMap);
        Log.e("YZS",hashMap.toString());
    }

    @Override
    public void initData() {



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:

                finish();
                break;
            case R.id.layout_search:
                Intent intent = new Intent(this,searchActivity.class);

                startActivity(intent);

                break;

        }

    }
    public String getToString(String[] arrayData) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < arrayData.length; i++) {
            stringBuilder.append(arrayData[i]);
            if (i < arrayData.length - 1) {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }
}
