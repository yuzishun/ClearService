package com.example.yuzishun.clearservice.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by yuzishun on 2018/7/30.
 */
//
public class MyApplication extends Application {
    private static MyApplication app;
    private Context context;
    public static MyApplication getInstance() {
        return app;
    }

    @Override
    public void onCreate() {


        super.onCreate();
        app = this;
//        getInstance();
        context = getApplicationContext();
    }
    public Context getContext(){
        return  context;
    }
    //  其他类使用 直接可以点出上下文
//    MyApplication app = (MyApplication)getApplication();
//    Context context = app.getContext();
}
