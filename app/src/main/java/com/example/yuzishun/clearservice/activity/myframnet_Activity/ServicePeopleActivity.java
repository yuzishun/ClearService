package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServicePeopleActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;

    @Override
    public int intiLayout() {
        return R.layout.activity_service_people;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);

        title_text.setText("服务人员信息");
        onCilck();

    }

    private void onCilck() {
        image_back.setOnClickListener(this);

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
        }

    }
}
