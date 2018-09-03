package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.adapter.GridViewAdapter;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.ClasssFitterBean;
import com.example.yuzishun.clearservice.model.UserUpdataBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ChooseCrdeActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.gv_channel)
    GridView mGridView;
    @BindView(R.id.id_ok)
    Button id_ok;
    private GridViewAdapter mGridViewAdapter;
    private List<ClasssFitterBean.DataBean> mList =  new ArrayList<>();
    ;
//    private String[] channel = {"家庭保洁", "保护月嫂", "做饭阿姨", "家庭保洁", "保姆月嫂", "做饭阿姨", "家庭保洁", "保护月嫂",
//            "做饭阿姨"};
    private String [] stringArray;
    ArrayList<String> stringArrayList = new ArrayList<String>();
    @Override
    public int intiLayout() {
        return R.layout.activity_choose_crde;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_text.setText("服务标签");

        onclick();
        newTel();
    }

    private void newTel() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("user_access_token",Content.Token);
        Observer<ClasssFitterBean> observer = new Observer<ClasssFitterBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ClasssFitterBean classsFitterBean) {
                Log.e("YZS",classsFitterBean.toString());
                if(classsFitterBean.getCode()==200){
                    mList =  classsFitterBean.getData();
                    initview();

                }
                else {
                    Toast.makeText(ChooseCrdeActivity.this, classsFitterBean.getMsg()+"", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onError(Throwable e) {
            Log.e("YZS",e.getMessage()+"");

            }

            @Override
            public void onComplete() {

            }
        };

        ApiMethods.getClassFitter(observer,hashMap);

    }

    private void initview() {

        mGridViewAdapter = new GridViewAdapter(this, mList);
        mGridView.setAdapter(mGridViewAdapter);
        //GridView的item的点击事件
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //将当前点击的position传递过去做相应的状态改变
                mGridViewAdapter.choiceState(position);




            }
        });
    }

    private void onclick() {
        image_back.setOnClickListener(this);
        id_ok.setOnClickListener(this);

    }

    @Override
    public void initData() {




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                finish();
                break;
            case R.id.id_ok:
//                Log.e("YZS",stringArrayList.toString());
//


                for (int i = 0; i <mList.size() ; i++) {
                    if(mList.get(i).isIs_filter()==true){
                        stringArrayList.add(mList.get(i).getClassify_name());

                    }

                }
                String s = ArrayList2String(stringArrayList);

                for (int i = 0; i <stringArrayList.size() ; i++) {


                }
                Log.e("YZS",s.toString());
                if (stringArrayList.size() == 0) {
                    Toast.makeText(this, "至少选择一个卡片", Toast.LENGTH_SHORT).show();
                } else {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("user_access_token", Content.Token);
                    hashMap.put("user_tag_array", s);
                    Observer<UserUpdataBean> observer = new Observer<UserUpdataBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(UserUpdataBean userUpdataBean) {
                            Log.e("YZS", userUpdataBean.toString());
                            if (userUpdataBean.getCode() == 200) {

                                Toast.makeText(ChooseCrdeActivity.this, "选择卡片成功", Toast.LENGTH_SHORT).show();
                                finish();

                            } else {
                                Toast.makeText(ChooseCrdeActivity.this, userUpdataBean.getMsg() + "", Toast.LENGTH_SHORT).show();
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
                    ApiMethods.getUserUpdata(observer, hashMap);
                    Log.e("YZS",hashMap.toString());

                    break;
                }
        }
    }
    // ArrayList类型转成String类型
    public String ArrayList2String(ArrayList<String> arrayList) {
        String result = "";
        if (arrayList != null && arrayList.size() > 0) {
            for (String item : arrayList) {
                // 把列表中的每条数据用逗号分割开来，然后拼接成字符串
                result += item + ",";
            }
            // 去掉最后一个逗号
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}
