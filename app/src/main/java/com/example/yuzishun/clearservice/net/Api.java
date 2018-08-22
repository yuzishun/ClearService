package com.example.yuzishun.clearservice.net;


import com.example.yuzishun.clearservice.model.classificationBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by yuzishun on 2018/8/13.
 */

public class Api {
//
//    public static String baseUrl = "http://192.168.0.181:7071/ald/v1/";
//
//    public static ApiService apiService;
//    //单例
//    public static ApiService getApiService() {
//        if (apiService == null) {
//            synchronized (Api.class) {
//                if (apiService == null) {
//                    new Api();
//                }
//            }
//        }
//        return apiService;
//    }
//
//    private Api() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())//请求的结果转为实体类
//                //适配RxJava2.0,RxJava1.x则为RxJavaCallAdapterFactory.create()
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//        apiService = retrofit.create(ApiService.class);
//    }

}
