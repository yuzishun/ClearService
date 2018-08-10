package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.base.BaseActivity;

import butterknife.ButterKnife;

public class OrderdetailsActivity extends BaseActivity {



    @Override
    public int intiLayout() {
        return R.layout.activity_orderdetails;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);

    }

    @Override
    public void initData() {

    }
}
