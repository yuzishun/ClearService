package com.example.yuzishun.clearservice;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.support.v4.app.FragmentManager;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.yuzishun.clearservice.Custom.MyViewPager;
import com.example.yuzishun.clearservice.activity.main.MainContact;
import com.example.yuzishun.clearservice.activity.main.MainPresenterImpl;
import com.example.yuzishun.clearservice.base.BaseMvpActivity;
import com.example.yuzishun.clearservice.utils.NetBroadCastReciver;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMvpActivity<MainContact.IMainPresenter>implements MainContact.IMainView {

    @BindView(R.id.myviewpager)
    MyViewPager mViewPager;
    @BindView(R.id.rg_main)
    RadioGroup mRg_main;
    private MainPresenterImpl mainPresenter;
    private FragmentManager fragmentManager;
    @Override
    public int intiLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        setBreoadcast();
        //逻辑实例化
        mainPresenter = new MainPresenterImpl();
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public void initData() {
        mainPresenter.Total(mViewPager,mRg_main,fragmentManager);



    }

    @Override
    protected MainContact.IMainPresenter createPresenter() {
        return new MainPresenterImpl();
    }

    /**
     * 设置网络监听
     */
    private void setBreoadcast() {
        BroadcastReceiver receiver = new NetBroadCastReciver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, filter);
    }

}
