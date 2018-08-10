package com.example.yuzishun.clearservice.activity.splach;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuzishun.clearservice.activity.main.MainContact;
import com.example.yuzishun.clearservice.present.MvpPresenter;
import com.example.yuzishun.clearservice.present.MvpView;

/**
 * Created by yuzishun on 2018/7/31.
 */

public class SplachContact {

    public interface ISplachView extends MvpView{


    }
    public interface ISplachPresenter extends MvpPresenter<ISplachView>{

        void initView(TextView textView, SplachActivity splachActivity);

    }

}
