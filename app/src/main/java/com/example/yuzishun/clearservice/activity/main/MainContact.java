package com.example.yuzishun.clearservice.activity.main;

import android.app.FragmentManager;
import android.content.Context;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.yuzishun.clearservice.Custom.MyViewPager;
import com.example.yuzishun.clearservice.present.MvpPresenter;
import com.example.yuzishun.clearservice.present.MvpView;


/**
 * Created by yuzishun on 2018/7/30.
 */

public class MainContact {
    public interface IMainView extends MvpView {

    }
    public interface IMainPresenter extends MvpPresenter<IMainView> {
        //处理主页面的数据
        void Total(MyViewPager myViewPager, RadioGroup radioGroup, android.support.v4.app.FragmentManager fragmentManager);


    }

}
