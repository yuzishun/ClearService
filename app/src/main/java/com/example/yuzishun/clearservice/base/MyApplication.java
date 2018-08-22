package com.example.yuzishun.clearservice.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.bulong.rudeness.RudenessScreenHelper;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.ThemeConfig;
import cn.finalteam.galleryfinal.widget.GFImageView;

/**
 * Created by yuzishun on 2018/7/30.
 */
//
public class MyApplication extends Application {
    private static MyApplication app;
    private static Context context;
    public static MyApplication getInstance() {
        return app;
    }

    @Override
    public void onCreate() {


        super.onCreate();
        app = this;

//        getInstance();
        context = getApplicationContext();
        int designWidth = 750;
        new RudenessScreenHelper(this, designWidth).activate();


    }



    public static Context getContext(){
        return  context;
    }
    //  其他类使用 直接可以点出上下文
//    MyApplication app = (MyApplication)getApplication();
//    Context context = app.getContext();



}
