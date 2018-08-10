package com.example.yuzishun.clearservice.activity.splach;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yuzishun.clearservice.MainActivity;
import com.example.yuzishun.clearservice.activity.login.LoginActivity;
import com.example.yuzishun.clearservice.activity.main.MainContact;
import com.example.yuzishun.clearservice.present.BaseMvpPresenter;
import com.example.yuzishun.clearservice.utils.SpUtil;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yuzishun on 2018/7/31.
 */

public class SplachPresenterImpl extends BaseMvpPresenter<SplachContact.ISplachView>implements SplachContact.ISplachPresenter {
    private Handler handler;
    private Runnable runnable;

    Timer timer = new Timer();
    private TimerTask task;
    private int recLen = 5;//跳过倒计时提示5秒

    @Override
    public void initView(final TextView textView, final SplachActivity splachActivity) {
        //测试
//        SpUtil spUtil = new SpUtil(splachActivity, "file");
//        int logining = 0;
//        spUtil.putInt("logining", logining);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpUtil spUtil = new SpUtil(splachActivity,"file");
                int logining = spUtil.getInt("logining", 0);
                if(logining==0){
                    //从闪屏界面跳转到登录界面，现在是没有登录过的状态下
                    Intent intent = new Intent(splachActivity, LoginActivity.class);
                    splachActivity.startActivity(intent);
                    splachActivity.finish();
                    if (runnable != null) {
                        handler.removeCallbacks(runnable);
                    }

                }else {
                    //从闪屏界面跳转到首界面
                    Intent intent = new Intent(splachActivity, MainActivity.class);
                    splachActivity.startActivity(intent);
                    splachActivity.finish();
                    if (runnable != null) {
                        handler.removeCallbacks(runnable);
                    }
                }



            }
        });
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                SpUtil spUtil = new SpUtil(splachActivity,"file");
                int logining = spUtil.getInt("logining", 0);
                if(logining==0){
                    //从闪屏界面跳转到登录界面，现在是没有登录过的状态下
                    Intent intent = new Intent(splachActivity, LoginActivity.class);
                    splachActivity.startActivity(intent);
                    splachActivity.finish();


                }else {
                    //从闪屏界面跳转到首界面
                    Intent intent = new Intent(splachActivity, MainActivity.class);
                    splachActivity.startActivity(intent);
                    splachActivity.finish();

                }

            }
        }, 5000);//延迟5S后发送handler信息


        task = new TimerTask() {
            @Override
            public void run() {
                splachActivity.runOnUiThread(new Runnable() { // UI thread
                    @Override
                    public void run() {
                        recLen--;
                        textView.setText("跳过 " + recLen);
                        if (recLen < 0) {
                            timer.cancel();
                            textView.setVisibility(View.GONE);//倒计时到0隐藏字体
                        }
                    }
                });
            }
        };
        timer.schedule(task, 1000, 1000);



    }



}
