package com.example.yuzishun.clearservice.net;

import com.example.yuzishun.clearservice.model.AutomaticBean;
import com.example.yuzishun.clearservice.model.CancelOrderBean;
import com.example.yuzishun.clearservice.model.ClasssFitterBean;
import com.example.yuzishun.clearservice.model.ConfimOrderBean;
import com.example.yuzishun.clearservice.model.CreatBean;
import com.example.yuzishun.clearservice.model.DefaultaddressBean;
import com.example.yuzishun.clearservice.model.DeleteOrderBean;
import com.example.yuzishun.clearservice.model.HomepagerRecommend;
import com.example.yuzishun.clearservice.model.LoginBean;
import com.example.yuzishun.clearservice.model.OrderBean;
import com.example.yuzishun.clearservice.model.OrderdetailsBean;
import com.example.yuzishun.clearservice.model.QiNiuBean;
import com.example.yuzishun.clearservice.model.ServiceinfocationBean;
import com.example.yuzishun.clearservice.model.UserBean;
import com.example.yuzishun.clearservice.model.UserUpdataBean;
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
import com.example.yuzishun.clearservice.model.telupdataBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

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

    //订单列表
    @POST("order")
    Observable<OrderBean> getOrder(@Body HashMap<String,String> hashMap);

    //i 七牛云
    @GET("QNtoken/getToken")
    Observable<QiNiuBean> getQiniu(@QueryMap Map<String,String> params);

    //订单详情
    @POST("order/info")
    Observable<OrderdetailsBean> getOrderdeils(@Body HashMap<String,String> hashMap);

    //地址更新
    @POST("address/update")
    Observable<telupdataBean> getupdatetel(@Body HashMap<String,String> hashMap);

    //用户更新
    @POST("user/update")
    Observable<UserUpdataBean> getUserUpdataBean(@Body HashMap<String,String> hashMap);

    //首页分类
    @POST("homepage/recommend")
    Observable<HomepagerRecommend> gethomePageRec(@Body HashMap<String,String> hashMap);

    //选择服务人员感兴趣的标签
    @POST("classify/filter")
    Observable<ClasssFitterBean> getClassfitter(@Body HashMap<String,String> hashMap);

    //取消订单
    @POST("order/cancel")
    Observable<CancelOrderBean> getCancelOrder(@Body HashMap<String,String> hashMap);

    //删除订单
    @POST("order/delete")
    Observable<DeleteOrderBean> getdeleteOrder(@Body HashMap<String,String> hashMap);

    //确定订单
    @POST("order/confirm")
    Observable<ConfimOrderBean> getConfimOrder(@Body HashMap<String,String> hashMap);

    //自动登录
    @POST("user/token/login")
    Observable<AutomaticBean> getAutomatic(@Body HashMap<String,String> hashMap);
    }
