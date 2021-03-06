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

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by DeMon on 2017/9/6.
 */

public class ApiMethods {

    /**
     * 封装线程管理和订阅的过程
     */
    public static void ApiSubscribe(Observable observable, Observer observer) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

//    /**
//     *
//     *
//     * @param observer 由调用者传过来的观察者对象
//     * @param start    起始位置
//     * @param count    获取长度
//     */
    /*public static void getTopMovie(Observer<Movie> observer, int start, int count) {
        ApiSubscribe(Api.getApiService().getTopMovie(start, count), observer);
    }*/
//    public static void getTopMovie(Observer<classificationBean> observer, HashMap<String,String> hashmap) {
//        ApiSubscribe(ApiStrategy.getApiService().getclassification(HashMap<String,String> hashmap), observer);
//    }

    public static void getclassifiction(Observer<classificationBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getclassification(hashMap),observer);

    }

    public static void getclasstwo(Observer<classBeantwo> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getclasstwo(hashMap),observer);
    }


    public static void getclassificationvideo(Observer<classificationvideoBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getclassificationvideo(hashMap),observer);
    }

    public static void getServiceinfo(Observer<ServiceinfocationBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getServiceinfo(hashMap),observer);
    }
    //验证码
    public static void getcode(Observer<codeBean> observer, HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getCode(hashMap),observer);
    }

    public static void getVerification(Observer<VerificationBean> observer, HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getVerification(hashMap),observer);
    }
    public static void getRegister(Observer<regiserBean> observer, HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getRegiser(hashMap),observer);
    }

    public static void getlogin(Observer<LoginBean> observer, HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getlogin(hashMap),observer);
    }

    public static void getdefaultaddress(Observer<DefaultaddressBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getdefaultaddress(hashMap),observer);
    }

    public static void getcreatordea(Observer<CreatBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getcreatbean(hashMap),observer);
    }

    public static void getUser(Observer<UserBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getuserbean(hashMap),observer);

    }
    public static void getaddress(Observer<addressBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getAddress(hashMap),observer);
    }

    public static void getforget(Observer<forgetBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getforget(hashMap),observer);

    }
    public static void getpaybao(Observer<paybaoBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getpayBean(hashMap),observer);

    }
    public static void getWeiChat(Observer<WeXchatBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getWechat(hashMap),observer);
    }

    public static void getaddtel(Observer<addtelBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getaddtel(hashMap),observer);

    }
    public static void getOrder(Observer<OrderBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getOrder(hashMap),observer);
    }

    public static void getQiniu(Observer<QiNiuBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getQiniu(hashMap),observer);
    }
    public static void  getOrderDeils(Observer<OrderdetailsBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getOrderdeils(hashMap),observer);
    }

    public static void getupdatatel(Observer<telupdataBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getupdatetel(hashMap),observer);
    }

    public static void getUserUpdata(Observer<UserUpdataBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getUserUpdataBean(hashMap),observer);
    }

    public static void getHomePageReco(Observer<HomepagerRecommend> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().gethomePageRec(hashMap),observer);
    }
    public static void getClassFitter(Observer<ClasssFitterBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getClassfitter(hashMap),observer);

    }

    public static void getCancelOrder(Observer<CancelOrderBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getCancelOrder(hashMap),observer);
    }

    public static void getDeltetOrder(Observer<DeleteOrderBean> observer,HashMap<String,String> hashMap){

        ApiSubscribe(ApiStrategy.getApiService().getdeleteOrder(hashMap),observer);
    }
    public static void getConfimOrder(Observer<ConfimOrderBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getConfimOrder(hashMap),observer);
    }
    public static void getAutomatic(Observer<AutomaticBean> observer,HashMap<String,String> hashMap){
        ApiSubscribe(ApiStrategy.getApiService().getAutomatic(hashMap),observer);
    }


}
