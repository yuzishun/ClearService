package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.changename.changepswActivity;
import com.example.yuzishun.clearservice.activity.login.LoginActivity;
import com.example.yuzishun.clearservice.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.outlog_id)
    Button outlog_id;
    @BindView(R.id.layout_langer)
    LinearLayout layout_langer;
    @BindView(R.id.layout_changepw)
    LinearLayout layout_changepw;
    @Override
    public int intiLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);

        title_text.setText(R.string.setting);
        onclickc();
    }

    private void onclickc() {
        image_back.setOnClickListener(this);
        outlog_id.setOnClickListener(this);
        layout_langer.setOnClickListener(this);
        layout_changepw.setOnClickListener(this);
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
            case R.id.outlog_id:
                Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.layout_langer:
                startActivity(new Intent(this,new langerActivity().getClass()));
                break;
            case R.id.layout_changepw:

                startActivity(new Intent(this,changepswActivity.class));
                break;
        }
    }
}
