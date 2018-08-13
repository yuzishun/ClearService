package com.example.yuzishun.clearservice.activity.mainfragment_activity;

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
    @Override
    public int intiLayout() {
        return R.layout.activity_submission;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_text.setText(R.string.commint_mission);
        image_back.setOnClickListener(this);
        layout_chosse.setOnClickListener(this);
        paylayout.setOnClickListener(this);
        choosetime.setOnClickListener(this);
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
            case R.id.layout_chosse:

                startActivity(new Intent(this,ChoosetelActivity.class));
                break;
            case R.id.paylayout:

                startActivity(new Intent(this,PayActivity.class));
                break;
            case R.id.choosetime:
                
                startActivity(new Intent(this,choosetimeActivity.class));
                break;
        }
    }
}
