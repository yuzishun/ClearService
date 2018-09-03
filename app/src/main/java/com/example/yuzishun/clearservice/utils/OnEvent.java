package com.example.yuzishun.clearservice.utils;

import android.os.Build;
import android.os.Bundle;

/**
 * Created by yuzishun on 2018/8/22.
 */

public class OnEvent {

    public String mMsg;
    public Bundle mbundle;
    public OnEvent(String msg) {
        // TODO Auto-generated constructor stub
        mMsg = msg;
    }
    public OnEvent(Bundle bundle){

    }

    public Bundle getbuild(){
        return mbundle;
    }
    public String getMsg(){
        return mMsg;
    }

}
