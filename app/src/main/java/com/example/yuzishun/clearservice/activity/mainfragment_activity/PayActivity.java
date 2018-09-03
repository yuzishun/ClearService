package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.WeXchatBean;
import com.example.yuzishun.clearservice.model.paybaoBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.utils.CountDownUtils;
import com.example.yuzishun.clearservice.utils.PayResult;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.Result;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PayActivity extends BaseActivity implements View.OnClickListener {
    private int SDK_PAY_FLAG = 0;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.Text_times)
    TextView Text_times;
    @BindView(R.id.surepay)
    Button surepay;
    @BindView(R.id.zhifu_check)
    CheckBox zhifu_check;
    @BindView(R.id.weixin_check)
    CheckBox weixin_check;
    @BindView(R.id.zhifu_layout)
    RelativeLayout layout_zhifu;
    @BindView(R.id.weixin_layout)
    RelativeLayout layout_weixin;
    public static PayActivity intentstan;
    private int time;
    @BindView(R.id.money)
    TextView money;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    Log.e("YZS",resultInfo.toString()+"");
                    Log.e("YZS",resultInfo.toString()+"");

                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        startActivity(new Intent(PayActivity.this,PaySucessActivity.class));

                        Toast.makeText(PayActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(PayActivity.this, "支付失败", Toast.LENGTH_SHORT).show();

                    }

        }
    };
    @Override
    public int intiLayout() {
        return R.layout.activity_pay;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        intentstan = this;
        title_text.setText("确认支付");
        image_back.setOnClickListener(this);
        layout_weixin.setOnClickListener(this);
        layout_zhifu.setOnClickListener(this);
        surepay.setOnClickListener(this);
        zhifu_check.setOnClickListener(this);
        weixin_check.setOnClickListener(this);
        Intent intent = getIntent();
        time = intent.getIntExtra("_time",0);

        money.setText("¥:"+Content.OrderMoney);
        long ping_ende1 = (int)time;
        long current1 = System.currentTimeMillis()/1000;
        new CountDownUtils(ping_ende1 - current1,Text_times).startCount();
    }

    @Override
    public void initData() {
        chec();

    }

    private void chec() {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                finish();
                break;
            case R.id.weixin_layout:
                weixin_check.setChecked(true);
                zhifu_check.setChecked(false);

                break;
            case R.id.zhifu_layout:
                zhifu_check.setChecked(true);
                weixin_check.setChecked(false);
                break;
            case R.id.surepay:
                if(weixin_check.isChecked()){
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("order_id", Content.OrderId);
                    hashMap.put("pay_type", "2");

                    Observer<WeXchatBean> observer = new Observer<WeXchatBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(WeXchatBean weXchatBean) {
                            Log.e("YZS",weXchatBean.getData().toString());
                            if(weXchatBean.getCode()==200){

                                //微信注册APPID
                                IWXAPI api = WXAPIFactory.createWXAPI(PayActivity.this,null);
                                api.registerApp(Content.APP_ID);
                                PayReq request = new PayReq();
                                request.appId = weXchatBean.getData().getAppid();
                                request.partnerId = weXchatBean.getData().getPartnerid();
                                request.prepayId = weXchatBean.getData().getPrepayid();
                                request.packageValue = weXchatBean.getData().getPackageX();
                                request.nonceStr= weXchatBean.getData().getNoncestr();
                                request.timeStamp= weXchatBean.getData().getTimestamp()+"";
                                request.sign= weXchatBean.getData().getSign();
                                Log.e("YZS",request.sign.toString()+request.appId+"");
                                api.sendReq(request);
                            }else {
                                Toast.makeText(PayActivity.this, weXchatBean.getMsg()+"", Toast.LENGTH_SHORT).show();

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

                    ApiMethods.getWeiChat(observer,hashMap);
                    Log.e("YZS",hashMap.toString());

                }else {
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("order_id", Content.OrderId);
                    hashMap.put("pay_type", "1");

                    Observer<paybaoBean> observer = new Observer<paybaoBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(paybaoBean paybaoBean) {
                           final String OrderInfo = paybaoBean.getData().toString();
                            if(paybaoBean.getCode()==200){

                                Runnable payRunnable = new Runnable() {
                                    @Override
                                    public void run() {


                                PayTask alipay = new PayTask(PayActivity.this);
                                Map<String, String> result = alipay.payV2(OrderInfo,true);

                                Message msg = new Message();
                                msg.what = SDK_PAY_FLAG;
                                msg.obj = result;
                                handler.sendMessage(msg);

                                    }
                                };
                                // 必须异步调用
                                Thread payThread = new Thread(payRunnable);
                                payThread.start();
                                
                            }else {
                                Toast.makeText(PayActivity.this, paybaoBean.getMsg()+"", Toast.LENGTH_SHORT).show();

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

                    ApiMethods.getpaybao(observer,hashMap);

                }



                break;
            case R.id.weixin_check:
                weixin_check.setChecked(true);
                zhifu_check.setChecked(false);

                break;
            case R.id.zhifu_check:
                zhifu_check.setChecked(true);
                weixin_check.setChecked(false);
                break;
        }
    }




}
