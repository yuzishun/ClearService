package com.example.yuzishun.clearservice.activity.register;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.Custom.ClearEditText;
import com.example.yuzishun.clearservice.Custom.VerifyCodeView;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.forget.CodeeActivity;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.model.VerificationBean;
import com.example.yuzishun.clearservice.model.codeBean;
import com.example.yuzishun.clearservice.net.ApiMethods;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CodeActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.Verify_Code)
    VerifyCodeView mVerify_Code;
    @BindView(R.id.text_back)
    ImageView mText_back;
    @BindView(R.id.button_getResule)
    Button mButton_getResule;
    @BindView(R.id.iphone)
    TextView iphone;
    private String number;
    private int i = 0;
    private InputMethodManager inputManager = null;

    @Override
    public int intiLayout() {
        return R.layout.activity_code;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        mText_back.setOnClickListener(this);

        mButton_getResule.setOnClickListener(this);
        final MyCountDownTimer myCountDownTimer = new MyCountDownTimer(60000, 1000);
        myCountDownTimer.start();
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        //  这是取出来的手机号，用手机号来发送短信验证码//接口
        number = intent.getStringExtra("number");
        iphone.setText(getString(R.string.send_success) + number);
//        mVerify_Code.setFocusable(true);
//        mVerify_Code.setFocusableInTouchMode(true);
//        mVerify_Code.requestFocus();
        mVerify_Code.showSoftInput();
        mVerify_Code.setInputCompleteListener(new VerifyCodeView.InputCompleteListener() {
            @Override
            public void inputComplete() {

                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("phone",number);
                hashMap.put("sms_type","1");
                hashMap.put("sms_code","999999");
                Observer<VerificationBean> observer = new Observer<VerificationBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VerificationBean verificationBean) {
                        if(verificationBean.getCode()==200){
                            Intent intent = new Intent(CodeActivity.this, PassWordActivity.class);
                            intent.putExtra("number", number);
                            startActivity(intent);
                            finish();

                        }else {
                            Toast.makeText(CodeActivity.this, verificationBean.getMsg()+"", Toast.LENGTH_SHORT).show();

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
                ApiMethods.getVerification(observer,hashMap);

//                //上一个页面回传过来的验证码的值，做比较，如果一样的话，就跳转，不一样，清空重新输入
//
//                //输入到最后一位判断验证码是否正确，正确的话跳转到设置密码页面，携带上手机号
//                Intent intent = new Intent(CodeActivity.this, PassWordActivity.class);
//                intent.putExtra("number", number);
//                startActivity(intent);
//                finish();

            }

            @Override
            public void invalidContent() {

            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_back:
                finish();
                break;
            case R.id.button_getResule:


                break;

        }
    }

    //倒计时函数
    private class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            //防止计时过程中重复点击
            mButton_getResule.setClickable(false);
            mButton_getResule.setText(l / 1000 + "秒");

        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //重新给Button设置文字
            mButton_getResule.setText(R.string.repeat);
            //设置可点击
            mButton_getResule.setClickable(true);
        }
    }

    private void clearTimer() {
//        if (task != null) {
//            task.cancel();
//            task = null;
//        }
//        if (timer != null) {
//            timer.cancel();
//            timer = null;
//        }
//    }
    }


}
