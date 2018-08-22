package com.example.yuzishun.clearservice.net;

import com.example.yuzishun.clearservice.model.CreatBean;
import com.example.yuzishun.clearservice.model.DefaultaddressBean;
import com.example.yuzishun.clearservice.model.LoginBean;
import com.example.yuzishun.clearservice.model.OrderBean;
import com.example.yuzishun.clearservice.model.ServiceinfocationBean;
import com.example.yuzishun.clearservice.model.UserBean;
import com.example.yuzishun.clearservice.model.VerificationBean;
import com.example.yuzishun.clearservice.model.WeXchatBean;
import com.example.yuzishun.clearservice.model.addressBean;
import com.example.yuzishun.clearservice.model.addtelBean;
import com.example.yuzishun.clearservice.model.classBeantwo;
import com.example.yuzishun.clearservice.model.classBeantwosp;
import com.example.yuzishun.clearservice.model.classificationBean;
import com.example.yuzishun.clearservice.model.classificationvideoBean;
import com.example.yuzishun.clearservice.model.codeBean;
import com.example.yuzishun.clearservice.model.forgetBean;
import com.example.yuzishun.clearservice.model.paybaoBean;
import com.example.yuzishun.clearservice.model.regiserBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by DeMon on 2017/9/6.
 */

public interface ApiService {

    //服务页面分类初始
    @POST("classify")
    Observable<classificationBean> getclassification(@Body HashMap<String, String> hashMap);

    //分类界面的二级分类
    @POST("classify")
    Observable<classBeantwo> getclasstwo(@Body HashMap<String,String> hashMap);

    //服务页面视屏以及洗小部件
    @POST("service")
    Observable<classificationvideoBean> getclassificationvideo(@Body HashMap<String,String> hashMap);

    //服务人员信息
    @POST("service/show")
    Observable<ServiceinfocationBean> getServiceinfo(@Body HashMap<String,String> hashMap);

    //手机号发送验证码
    @POST("sms/send")
    Observable<codeBean> getCode(@Body HashMap<String,String> hashMap);

    //验证码验证是否正确
    @POST("sms/check")
    Observable<VerificationBean> getVerification(@Body HashMap<String,String> hashMap);

    //用户注册
    @POST("user/register")
    Observable<regiserBean> getRegiser(@Body HashMap<String,String> hashMap);

    //忘记密码
    @POST("user/forget_password")
    Observable<forgetBean> getforget(@Body HashMap<String,String> hashMap);

    //用户登录
    @POST("user/login")
    Observable<LoginBean> getlogin(@Body HashMap<String,String> hashMap);

    //默认地址
    @POST("address/get_default_info")
    Observable<DefaultaddressBean> getdefaultaddress(@Body HashMap<String,String> hashMap);

    //创建订单
    @POST("order/create")
    Observable<CreatBean> getcreatbean(@Body HashMap<String,String> hashMap);

    //用户信息
    @POST("user/show")
    Observable<UserBean> getuserbean(@Body HashMap<String,String> hashMap);

    //服务人员地址列表
    @POST("address")
    Observable<addressBean> getAddress(@Body HashMap<String,String> hashMap);

    //支付宝支付
    @POST("order/pay")
    Observable<paybaoBean> getpayBean(@Body HashMap<String,String> hashMap);

    //微信支付
    @POST("order/pay")
    Observable<WeXchatBean> getWechat(@Body HashMap<String,String> hashMap);

    //新增地址
    @POST("address/create")
    Observable<addtelBean> getaddtel(@Body HashMap<String,String> hashMap);

    //订单
    @POST("order")
    Observable<OrderBean> getOrder(@Body HashMap<String,String> hashMap);

    }
