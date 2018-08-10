package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class langerActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @Override
    public int intiLayout() {
        return R.layout.activity_langer;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);

        title_text.setText(R.string.lager_chinses);
        image_back.setOnClickListener(this);
        onclick();


    }
    private void onclick() {
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
