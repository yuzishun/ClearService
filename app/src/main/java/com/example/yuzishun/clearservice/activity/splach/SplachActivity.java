package com.example.yuzishun.clearservice.activity.splach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.login.LoginActivity;
import com.example.yuzishun.clearservice.base.BaseMvpActivity;
import com.example.yuzishun.clearservice.present.MvpPresenter;
import com.example.yuzishun.clearservice.tools.CountryActivity;
import com.example.yuzishun.clearservice.utils.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SplachActivity extends BaseMvpActivity {
    @BindView(R.id.Splach_id)
    ImageView mSplach_id;
    @BindView(R.id.text_time)
    TextView text_time;

    private SplachPresenterImpl presenter;
    @Override
    public int intiLayout() {
        return R.layout.activity_splach;

    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        //使用sp初始化选择城市选项
        SpUtil spUtil = new SpUtil(SplachActivity.this,"country_number");
        String country_nbumber="+86";
        spUtil.putString("countryNumber",country_nbumber);
        SpUtil spUtil2 = new SpUtil(SplachActivity.this,"postion");
        spUtil2.remove("postion");
        presenter = new SplachPresenterImpl();
        presenter.initView(text_time,this);

    }

    @Override
    public void initData() {

    }
    @Override
    protected MvpPresenter createPresenter() {
        return new SplachPresenterImpl();
    }
}
