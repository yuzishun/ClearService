package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.base.BaseActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PayActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.Text_times)
    TextView Text_times;
    private long countdownTime;//倒计时的总时间(单位:毫秒)
    private String timefromServer;//从服务器获取的订单生成时间
    private long chaoshitime;//从服务器获取订单有效时长(单位:毫秒)
    @BindView(R.id.surepay)
    Button surepay;
    @BindView(R.id.zhifu_check)
    CheckBox zhifu_check;
    @BindView(R.id.weixin_check)
    CheckBox weixin_check;
    @BindView(R.id.zhifu_layout)
    RelativeLayout layout_zhifu;
    @BindView(R.id.weixin_layout)
    RelativeLayout layout_weixin;
    @Override
    public int intiLayout() {
        return R.layout.activity_pay;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_text.setText("确认支付");
        image_back.setOnClickListener(this);
        layout_weixin.setOnClickListener(this);
        layout_zhifu.setOnClickListener(this);
        surepay.setOnClickListener(this);
        zhifu_check.setOnClickListener(this);
        weixin_check.setOnClickListener(this);
    }

    @Override
    public void initData() {
        getTimeDuring();
        chec();

    }

    private void chec() {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                finish();
                break;
            case R.id.weixin_layout:
                weixin_check.setChecked(true);
                zhifu_check.setChecked(false);

                break;
            case R.id.zhifu_layout:
                zhifu_check.setChecked(true);
                weixin_check.setChecked(false);
                break;
            case R.id.surepay:
                startActivity(new Intent(this,PaySucessActivity.class));
                break;
            case R.id.weixin_check:
                weixin_check.setChecked(true);
                zhifu_check.setChecked(false);

                break;
            case R.id.zhifu_check:
                zhifu_check.setChecked(true);
                weixin_check.setChecked(false);
                break;
        }
    }


    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            countdownTime -= 1000;//倒计时总时间减1

            SimpleDateFormat minforamt = new SimpleDateFormat("mm:ss");

            String hms = minforamt.format(countdownTime);//格式化倒计时的总时间
            Text_times.setText("确认支付剩余时间:" + hms);
            handler.postDelayed(this, 1000);
        }
    };

    private void getTimeDuring() {
        chaoshitime = 30 * 60 * 1000;//应该从服务器获取

        timefromServer = "2017-01-23 11:40:50";//应该从服务器获取
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date serverDate = df.parse(timefromServer);

            long duringTime = new Date().getTime() - serverDate.getTime();//计算当前时间和从服务器获取的订单生成时间的时间差
            countdownTime = chaoshitime - duringTime;//计算倒计时的总时间

            handler.postDelayed(runnable, 1000);

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
