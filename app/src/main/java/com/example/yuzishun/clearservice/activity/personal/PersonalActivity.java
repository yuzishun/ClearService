package com.example.yuzishun.clearservice.activity.personal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.main.MainPresenterImpl;
import com.example.yuzishun.clearservice.base.BaseMvpActivity;
import com.example.yuzishun.clearservice.present.MvpPresenter;

//个人的资料页面
public class PersonalActivity extends BaseMvpActivity {

    @Override
    protected MvpPresenter createPresenter() {
        return new MainPresenterImpl();
    }

    @Override
    public int intiLayout() {
        return R.layout.activity_personal;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
