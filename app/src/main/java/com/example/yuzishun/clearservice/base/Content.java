package com.example.yuzishun.clearservice.base;

import android.app.Application;
import android.content.Intent;

import com.example.yuzishun.clearservice.utils.SpUtil;

/**
 * Created by yuzishun on 2018/8/13.
 */

public class Content extends Application{

   public static String userid="";
   //七牛上传图片域名
   public static String domain = "http://pdsqka1ws.bkt.clouddn.com/";
   //测试TOKEN n7n15izAG9YRqo1OTMHSX40b
   public static String Token="";
   //选择时间标记
   public static String chooseTime="";
   //选择地址和编辑地址
   public static int  choosetel=0;

   //订单ID
   public static String OrderId="";

   //订单的价钱
   public static float OrderMoney=0;

   //微信支付APP_ID
   public static String APP_ID ="wx94fbc1be78e61ee3";
   @Override
   public void onCreate() {
      super.onCreate();
      SpUtil spUtil1 = new SpUtil(getApplicationContext(),"Userid");
      userid = spUtil1.getString("User_id","null");
   }
}
