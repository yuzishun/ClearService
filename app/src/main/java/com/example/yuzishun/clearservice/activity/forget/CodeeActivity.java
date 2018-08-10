package com.example.yuzishun.clearservice.activity.forget;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuzishun.clearservice.Custom.VerifyCodeView;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.register.CodeActivity;
import com.example.yuzishun.clearservice.activity.register.PassWordActivity;
import com.example.yuzishun.clearservice.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CodeeActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.Verify_Code)
    VerifyCodeView mVerify_Code;
    @BindView(R.id.text_back)
    ImageView mText_back;
    @BindView(R.id.button_getResule)
    Button mButton_getResule;
    @BindView(R.id.text_number)
    TextView text_number;
    private String number;

    @Override
    public int intiLayout() {
        return R.layout.activity_codee;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        mText_back.setOnClickListener(this);
        mButton_getResule.setOnClickListener(this);
        MyCountDownTimer myCountDownTimer = new MyCountDownTimer(60000, 1000);
        myCountDownTimer.start();
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        //  这是取出来的手机号，用手机号来发送短信验证码//接口
        number = intent.getStringExtra("number");
        text_number.setText(getString(R.string.send_success)+number);
        mVerify_Code.showSoftInput();

        mVerify_Code.setInputCompleteListener(new VerifyCodeView.InputCompleteListener() {
            @Override
            public void inputComplete() {
                //在这里用手机号来发送短信验证码

                //输入到最后一位判断验证码是否正确，正确的话跳转到设置密码页面，携带上手机号
                Intent intent = new Intent(CodeeActivity.this,RepeatPwActivity.class);
                intent.putExtra("number", number);
                startActivity(intent);
                finish();

            }

            @Override
            public void invalidContent() {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_back:
                finish();
                break;
            case R.id.button_getResule:

//                mVerify_Code.setEnabled(true);
//                mVerify_Code.setFocusableInTouchMode(true);



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
}
