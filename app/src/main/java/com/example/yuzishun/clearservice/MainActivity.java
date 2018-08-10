package com.example.yuzishun.clearservice;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.yuzishun.clearservice.Custom.MyViewPager;
import com.example.yuzishun.clearservice.activity.main.MainContact;
import com.example.yuzishun.clearservice.activity.main.MainPresenterImpl;
import com.example.yuzishun.clearservice.base.BaseMvpActivity;
import com.example.yuzishun.clearservice.fragment.homepager.HomePagerFragment;
import com.example.yuzishun.clearservice.fragment.my.MyFragment;
import com.example.yuzishun.clearservice.fragment.service.ServiceFragment;
import com.example.yuzishun.clearservice.fragment.webview.WebViewFragment;
import com.example.yuzishun.clearservice.utils.NetBroadCastReciver;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity<MainContact.IMainPresenter>implements MainContact.IMainView {


    @BindView(R.id.rg_main)
    RadioGroup mRg_main;
    @BindView(R.id.content)
    FrameLayout content;
    private MainPresenterImpl mainPresenter;
    private FragmentManager fragmentManager;
    private int mIndex=0;
    private Fragment[] mFragments;
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
//        mainPresenter.Total(mViewPager,mRg_main,fragmentManager);
        initFragment();


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
    private void initFragment() {
        Fragment mTab_01 = new HomePagerFragment();
        Fragment mTab_02 = new ServiceFragment();
        Fragment mTab_03 = new WebViewFragment();
        Fragment mTab_04 = new MyFragment();

        //添加到数组
        mFragments = new Fragment[]{mTab_01,mTab_02,mTab_03,mTab_04};

        //开启事务

        FragmentTransaction ft =
                getSupportFragmentManager().beginTransaction();

        //添加首页
        ft.add(R.id.content,mTab_01).commit();

        //默认设置为第0个
        setIndexSelected(0);


    }
    private void setIndexSelected(int index) {

        if(mIndex==index){
            return;
        }
        FragmentManager    fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft              = fragmentManager.beginTransaction();


        //隐藏
        ft.hide(mFragments[mIndex]);
        //判断是否添加
        if(!mFragments[index].isAdded()){
            ft.add(R.id.content,mFragments[index]).show(mFragments[index]);
        }else {
            ft.show(mFragments[index]);
        }

        ft.commit();
        //再次赋值
        mIndex=index;

    }
    @OnClick({R.id.id_tab_01, R.id.id_tab_02, R.id.id_tab_03, R.id.id_tab_04})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_tab_01:
                setIndexSelected(0);
                break;
            case R.id.id_tab_02:
                setIndexSelected(1);
                break;
            case R.id.id_tab_03:
                setIndexSelected(2);
                break;
            case R.id.id_tab_04:
                setIndexSelected(3);
                break;
        }

    }
}
