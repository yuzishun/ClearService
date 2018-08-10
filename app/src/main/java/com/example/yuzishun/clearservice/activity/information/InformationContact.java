package com.example.yuzishun.clearservice.activity.information;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.present.MvpPresenter;
import com.example.yuzishun.clearservice.present.MvpView;

/**
 * Created by yuzishun on 2018/8/2.
 */

public class InformationContact {
    public interface infomationView extends MvpView{


    }

    public interface infomationPresenter extends MvpPresenter<infomationView>{
        //初始化的控件
        void initView();

        //选择自己在家庭中的角色
        void framilyname(LinearLayout framily_lyout, TextView framily_name,InformationActivity informationActivity);



    }

}
