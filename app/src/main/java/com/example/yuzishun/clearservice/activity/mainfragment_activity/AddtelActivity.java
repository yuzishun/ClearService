package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.Custom.ClearEditText;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.telActivity;
import com.example.yuzishun.clearservice.adapter.RecyclerViewTel_Adapter;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.addressBean;
import com.example.yuzishun.clearservice.model.addtelBean;
import com.example.yuzishun.clearservice.model.telupdataBean;
import com.example.yuzishun.clearservice.net.ApiMethods;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
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
    private Intent intent;
    private String id;
    private String suocity,jingwei;
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
        //这里进行选择，如果是1的话就是更改地址，如果是0的话就是新增地址
        intent = getIntent();
        id = intent.getStringExtra("id");
        if(Content.choosetel==0){
            button_cun.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    newTel();

                }
            });
        }else if(Content.choosetel==1){
            fill();


        }



    }

    private void fill() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("user_access_token", Content.Token);
        hashMap.put("page","0");
        hashMap.put("size","100");
        Observer<addressBean> observer = new Observer<addressBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(final addressBean addressBean) {
                if(addressBean.getCode()==200) {
                    Log.e("YZS",id+"");
                    for (int i = 0; i <addressBean.getData().getList().size() ; i++) {
                        if(addressBean.getData().getList().get(i).get_id().equals(id)){
                            name_cltext.setText(addressBean.getData().getList().get(i).getUser_name());
                            number_cltext.setText(addressBean.getData().getList().get(i).getMobile_phone()+"");
                            tel_text.setText(addressBean.getData().getList().get(i).getAddress_info());
                            city.setText(addressBean.getData().getList().get(i).getAddress_name());
                            try {

                                jingwei=addressBean.getData().getList().get(i).getAddress_point().get(0)+","+addressBean.getData().getList().get(i).getAddress_point().get(1);
                                suocity = (addressBean.getData().getList().get(i).getAddress_city());

                            }catch (Exception e){

                            }
                        }



                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("YZS",e.getMessage());

            }

            @Override
            public void onComplete() {

            }
        };
        ApiMethods.getaddress(observer,hashMap);
        Log.e("YZS",hashMap.toString());

        button_cun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



        HashMap<String,String> hashMap1 = new HashMap<>();
        hashMap1.put("_id",id);
        hashMap1.put("user_access_token",Content.Token);
        hashMap1.put("address_point",jingwei);
        hashMap1.put("address_name",city.getText().toString().trim() + "");
        hashMap1.put("address_info", tel_text.getText().toString().trim());
        hashMap1.put("address_city", suocity);
        hashMap1.put("user_name", name_cltext.getText().toString().trim() + "");
        hashMap1.put("mobile_phone", number_cltext.getText().toString().trim() + "");
        hashMap1.put("is_default","0");
        Observer<telupdataBean> observer1 = new Observer<telupdataBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(telupdataBean telupdataBean) {


                if(telupdataBean.getCode()==200){
                    Toast.makeText(AddtelActivity.this, "更改成功", Toast.LENGTH_SHORT).show();
                    finish();
                }else {

                    Toast.makeText(AddtelActivity.this, telupdataBean.getMsg()+"", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        ApiMethods.getupdatatel(observer1,hashMap1);
        Log.e("YZS",hashMap1.toString());

            }
        });
    }

    private void newTel() {
//        String[] data = new String[]{"121.472517","31.268818"};
//        List list =new ArrayList();
//        for (int i = 0; i <data.length ; i++) {
//            list.add(data[i]);
//
//        }
//        String toString = getToString(data);
        if(suocity.equals("")&&jingwei.equals("")){

        }else {

            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("user_access_token", Content.Token);
            hashMap.put("address_point", jingwei);
            hashMap.put("address_name", city.getText().toString().trim() + "");
            hashMap.put("address_info", tel_text.getText().toString().trim());
            hashMap.put("address_city", suocity);
            hashMap.put("user_name", name_cltext.getText().toString().trim() + "");
            hashMap.put("mobile_phone", number_cltext.getText().toString().trim() + "");

            Observer<addtelBean> observer = new Observer<addtelBean>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(addtelBean addtelBean) {
                    if (addtelBean.getCode() == 200) {

                        Toast.makeText(AddtelActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                        //数据是使用Intent返回
                        Intent intent = new Intent();
                        int i = 1;
                        //把返回数据存入Intent
                        intent.putExtra("result", i);
                        //设置返回数据
                        setResult(RESULT_OK, intent);
                        //关闭Activity
                        finish();
                    } else {
                        Toast.makeText(AddtelActivity.this, addtelBean.getMsg() + "", Toast.LENGTH_SHORT).show();

                    }

                }

                @Override
                public void onError(Throwable e) {

                    Log.e("YZS", e.getMessage());
                }

                @Override
                public void onComplete() {

                }
            };

            ApiMethods.getaddtel(observer, hashMap);
            Log.e("YZS", hashMap.toString());
        }
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

                startActivityForResult(intent,50);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==50&&resultCode==50){

//            Bundle bundle = data.getExtras().getBundle("loction_bundle");
//            Log.e("YZS",bundle.toString());
            suocity = data.getStringExtra("city");
            Log.e("YZS",city+"");
            city.setText(data.getStringExtra("loction_text"));
            jingwei = data.getStringExtra("loction_jw");


        }

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
