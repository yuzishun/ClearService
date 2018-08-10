package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.PayActivity;
import com.example.yuzishun.clearservice.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceDeileActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.pay_button)
    Button pay_button;

    @Override
    public int intiLayout() {
        return R.layout.activity_service_deile;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_text.setText("发布服务需求详情");
        image_back.setOnClickListener(this);
        pay_button.setOnClickListener(this);

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
            case R.id.pay_button:
                startActivity(new Intent(this, PayActivity.class));
                break;
        }
    }
}
