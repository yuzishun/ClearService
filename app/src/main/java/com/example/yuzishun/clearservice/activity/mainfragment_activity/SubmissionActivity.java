package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.CreatBean;
import com.example.yuzishun.clearservice.model.DefaultaddressBean;
import com.example.yuzishun.clearservice.model.ServiceinfocationBean;
import com.example.yuzishun.clearservice.model.addressBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.utils.OnEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SubmissionActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.layout_chosse)
    LinearLayout layout_chosse;
    @BindView(R.id.paylayout)
    LinearLayout paylayout;
    @BindView(R.id.choosetime)
    LinearLayout choosetime;
    @BindView(R.id.service_image)
    ImageView service_image;
    @BindView(R.id.text_work)
    TextView text_work;
    @BindView(R.id.money_text2)
    TextView money_text2;
    @BindView(R.id.money_text)
    TextView money_text;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.tel_xx)
    TextView tel_xx;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.Service_time)
    TextView Service_time;
    @BindView(R.id.visibility_text)
    TextView visibility_text;
    private String id;
    public static SubmissionActivity intentsat;

    private ServiceinfocationBean serviceinfocationBean;
    private int time=0;
    private String tel_id;
    private List<addressBean.DataBean.ListBean> listYse = new ArrayList();
    @Override
    public int intiLayout() {
        return R.layout.activity_submission;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        intentsat = this;
        title_text.setText(R.string.commint_mission);
        image_back.setOnClickListener(this);
        layout_chosse.setOnClickListener(this);
        paylayout.setOnClickListener(this);
        choosetime.setOnClickListener(this);
        Intent intent = getIntent();
        serviceinfocationBean = (ServiceinfocationBean) intent.getSerializableExtra("serviceinfocationBean");
        id = intent.getStringExtra("_id");
        Log.e("YZS",Content.chooseTime+"");
    }

    @Override
    public void initData() {
        settingDate();
        chooseaddress();


    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("YZS",Content.chooseTime+"");
        if(Content.chooseTime.equals("")){

        }else {
        time= Integer.parseInt(Content.chooseTime);
            Service_time.setText("服务时间："+com.example.yuzishun.clearservice.utils.TimeUtils.getFeture(time));
    }


    }

    private void chooseaddress() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("user_access_token", Content.Token);
        hashMap.put("service_filter_id",id);
        if(id.equals("")||Content.Token.equals("")){
            Toast.makeText(this, "参数有空", Toast.LENGTH_SHORT).show();
        }else {
            Observer<DefaultaddressBean> observer = new Observer<DefaultaddressBean>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(final DefaultaddressBean defaultaddressBean) {

                    if (defaultaddressBean.getCode() == 200) {
                        if(defaultaddressBean.getData().getIs_filter()==0){
                            visibility_text.setVisibility(View.VISIBLE);
                            name.setVisibility(View.GONE);
                            phone.setVisibility(View.GONE);
                            tel_xx.setVisibility(View.GONE);
                            tel_id = defaultaddressBean.getData().get_id();
                        }else {
                            name.setText(defaultaddressBean.getData().getUser_name());
                            phone.setText(defaultaddressBean.getData().getMobile_phone() + "");
                            tel_xx.setText(defaultaddressBean.getData().getAddress_city() + "" + defaultaddressBean.getData().getAddress_name() + "" + defaultaddressBean.getData().getAddress_info());
                            tel_id = defaultaddressBean.getData().get_id();
                        }
                        layout_chosse.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(SubmissionActivity.this,ChoosetelActivity.class);
                                intent.putExtra("_id",id);
                                startActivityForResult(intent,30);

                            }
                        });
                    }else {
                        Toast.makeText(SubmissionActivity.this, defaultaddressBean.getMsg()+"", Toast.LENGTH_SHORT).show();
                    }


                }

                @Override
                public void onError(Throwable e) {
                    Log.e("YZS",e.getMessage());
//                    Toast.makeText(SubmissionActivity.this, "请求失败,请看报错信息", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onComplete() {

                }
            };

            ApiMethods.getdefaultaddress(observer, hashMap);

        }

    }


//

    private void settingDate() {
        for (int i = 0; i <serviceinfocationBean.getData().getService_banner_img().size() ; i++) {
            Glide.with(this).load(serviceinfocationBean.getData().getService_banner_img().get(0)).into(service_image);
        }
        text_work.setText(serviceinfocationBean.getData().getService_name());
        money_text.setText("¥:"+serviceinfocationBean.getData().getService_money()+"");
        money_text2.setText("¥:"+serviceinfocationBean.getData().getService_money()+"");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:

                finish();
                break;

            case R.id.paylayout:
                Log.e("YZS",tel_id+"");
                if(!(id.equals("")&&Content.Token.equals("")&&time==0)){

                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("user_access_token",Content.Token);
                hashMap.put("service_id",id);
                hashMap.put("service_time",time+"");
                hashMap.put("user_address_id",tel_id);

                Observer<CreatBean> observer = new Observer<CreatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CreatBean creatBean) {
                        if(creatBean.getCode()==200){
                            Intent intent = new Intent(SubmissionActivity.this,PayActivity.class);
                            Content.OrderId = creatBean.getData().get_id();
                            Content.OrderMoney = creatBean.getData().getOrder_pay_money();
                            intent.putExtra("_time",creatBean.getData().getOver_order_time());
                            startActivity(intent);

                        }else {
                            Toast.makeText(SubmissionActivity.this, creatBean.getMsg()+"", Toast.LENGTH_SHORT).show();

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

                ApiMethods.getcreatordea(observer,hashMap);
                    Log.e("YZS",hashMap.toString()+"");

                }else {
                    Toast.makeText(this, "参数为空", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.choosetime:
                Intent intent = new Intent(SubmissionActivity.this,choosetimeActivity.class);
                intent.putExtra("_id",id);
                startActivity(intent);
                break;
        }




    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==30&&resultCode==30){
            visibility_text.setVisibility(View.GONE);
            name.setVisibility(View.VISIBLE);
            phone.setVisibility(View.VISIBLE);
            tel_xx.setVisibility(View.VISIBLE);
            Bundle bundle = data.getExtras().getBundle("bundle");
            name.setText(bundle.getString("name"));
                phone.setText(bundle.getString("phone")+"");
                tel_xx.setText(bundle.getString("city")+bundle.getString("addressname")+bundle.getString("info"));
                tel_id = bundle.getString("id");

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
