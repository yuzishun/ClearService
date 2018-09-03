package com.example.yuzishun.clearservice.activity.splach;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.MainActivity;
import com.example.yuzishun.clearservice.activity.login.LoginActivity;
import com.example.yuzishun.clearservice.activity.main.MainContact;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.AutomaticBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.present.BaseMvpPresenter;
import com.example.yuzishun.clearservice.utils.SpUtil;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

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
                final String  Token = spUtil.getString("login", "null");

                Log.e("YZS",Token.toString()+"");

                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("user_access_token",Token);
                Observer<AutomaticBean> observer = new Observer<AutomaticBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AutomaticBean automaticBean) {
                        if(automaticBean.getCode()==200){
                            Content.Token = Token;
                            //从闪屏界面跳转到首界面
                            Intent intent = new Intent(splachActivity, MainActivity.class);
                            splachActivity.startActivity(intent);
                            splachActivity.finish();
                            if (runnable != null) {
                                handler.removeCallbacks(runnable);
                            }
                        }else {
                            Toast.makeText(splachActivity, automaticBean.getMsg()+"", Toast.LENGTH_SHORT).show();
                            //从闪屏界面跳转到登录界面，现在是没有登录过的状态下
                            Intent intent = new Intent(splachActivity, LoginActivity.class);
                            splachActivity.startActivity(intent);
                            splachActivity.finish();
                            if (runnable != null) {
                                handler.removeCallbacks(runnable);
                            }

                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("YZS",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                };
                ApiMethods.getAutomatic(observer,hashMap);









            }
        });
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                SpUtil spUtil = new SpUtil(splachActivity,"file");
                String  Token = spUtil.getString("login", "null");
                Content.Token = Token;
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("user_access_token",Token);
                Observer<AutomaticBean> observer = new Observer<AutomaticBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AutomaticBean automaticBean) {
                        if(automaticBean.getCode()==200){

                            //从闪屏界面跳转到首界面
                            Intent intent = new Intent(splachActivity, MainActivity.class);
                            splachActivity.startActivity(intent);
                            splachActivity.finish();
                            if (runnable != null) {
                                handler.removeCallbacks(runnable);
                            }
                        }else {
                            Toast.makeText(splachActivity, automaticBean.getMsg()+"", Toast.LENGTH_SHORT).show();
                            //从闪屏界面跳转到登录界面，现在是没有登录过的状态下
                            Intent intent = new Intent(splachActivity, LoginActivity.class);
                            splachActivity.startActivity(intent);
                            splachActivity.finish();
                            if (runnable != null) {
                                handler.removeCallbacks(runnable);
                            }

                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("YZS",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                };
                ApiMethods.getAutomatic(observer,hashMap);

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
