package com.example.yuzishun.clearservice.base;

import android.app.Application;
import android.content.Intent;

import com.example.yuzishun.clearservice.utils.SpUtil;

/**
 * Created by yuzishun on 2018/8/13.
 */

public class Content extends Application{

   public String BeasUrl="http://192.168.0.178:7071/ald/v1/";
   public static String userid="";


   public static String Token="n7n15izAG9YRqo1OTMHSX40b";
   //选择时间标记
   public static String chooseTime="";
   @Override
   public void onCreate() {
      super.onCreate();
      SpUtil spUtil1 = new SpUtil(getApplicationContext(),"Userid");
      userid = spUtil1.getString("User_id","null");
   }
}
