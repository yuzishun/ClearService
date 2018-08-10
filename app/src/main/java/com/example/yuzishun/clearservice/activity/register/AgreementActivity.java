package com.example.yuzishun.clearservice.activity.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.changename.changepswActivity;
import com.example.yuzishun.clearservice.activity.login.LoginActivity;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.SettingActivity;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.langerActivity;
import com.example.yuzishun.clearservice.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AgreementActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;

    @Override
    public int intiLayout() {
        return R.layout.activity_agreement;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);

        title_text.setText("阿拉丁服务协议");
        onclickc();
    }

    private void onclickc() {
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
