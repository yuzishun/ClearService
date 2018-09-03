package com.example.yuzishun.clearservice.activity.forget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.Custom.CheckEditForButton;
import com.example.yuzishun.clearservice.Custom.ClearEditText;
import com.example.yuzishun.clearservice.Custom.EditTextChangeListener;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.login.LoginActivity;
import com.example.yuzishun.clearservice.activity.register.CodeActivity;
import com.example.yuzishun.clearservice.activity.register.RegisterActivity;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.model.codeBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.tools.CountryActivity;
import com.example.yuzishun.clearservice.utils.RegexUtils;
import com.example.yuzishun.clearservice.utils.SpUtil;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PhotoActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.text_back)
    ImageView mText_back;
    @BindView(R.id.photo_number)
    ClearEditText mPhoto_number;
    @BindView(R.id.button_getResule)
    Button mButton_getResule;
    private RegexUtils regexUtils;
    @BindView(R.id.layout_country)
    LinearLayout layout_country;
    @BindView(R.id.country_number)
    TextView country_number;

    @Override
    public int intiLayout() {
        return R.layout.activity_photo;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        mButton_getResule.setEnabled(false);

        mText_back.setOnClickListener(this);
        mButton_getResule.setOnClickListener(this);
        regexUtils = new RegexUtils(this);
        mPhoto_number.setFocusable(true);
        mPhoto_number.setFocusableInTouchMode(true);
        layout_country.setOnClickListener(this);
        mPhoto_number.requestFocus();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        CheckEditForButton checkEditForButton = new CheckEditForButton(mButton_getResule);
        checkEditForButton.addEditText(mPhoto_number);
        checkEditForButton.setListener(new EditTextChangeListener() {
            @Override
            public void allHasContent(boolean isHasContent) {
                if (isHasContent) {
//                    if(regexUtils.isPassWord(password)==true && regexUtils.isPhone(user)==true){
                    mButton_getResule.setEnabled(true);
//                    }
                } else {

                }
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_back:

                finish();
                break;
            case R.id.button_getResule:
                final String number = mPhoto_number.getText().toString().trim();
                if(number.equals("")){
                    Toast.makeText(this, R.string.photo_empt, Toast.LENGTH_SHORT).show();

                }else {
                    if (regexUtils.isPhone(number)==false) {
                        Toast.makeText(this, R.string.Wrongful, Toast.LENGTH_SHORT).show();

                    } else {
                        //在这里利用手机号发送验证码，验证码传到下一个验证验证码的界面
                        HashMap<String,String> hashMap = new HashMap<>();
                        hashMap.put("phone",number);
                        hashMap.put("sms_type","2");
                        Observer<codeBean> observer = new Observer<codeBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(codeBean codebean) {
                                if(codebean.getCode()==200){
                                    Intent intent = new Intent(PhotoActivity.this, CodeeActivity.class);
                                    intent.putExtra("number", number);
                                    startActivity(intent);
                                    finish();

                                }else {
                                    Toast.makeText(PhotoActivity.this, codebean.getMsg()+"", Toast.LENGTH_SHORT).show();

                                }



                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("YZS",e.getMessage());

//                                Toast.makeText(PhotoActivity.this, "发送失败，可能是网络原因，或者是手机号不正确", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onComplete() {

                            }
                        };
                        ApiMethods.getcode(observer,hashMap);


                    }


                }

                break;
            case R.id.layout_country:
                Intent intent1 = new Intent(this, CountryActivity.class);
                intent1.putExtra("country_number",country_number.getText().toString().trim());
                startActivity(intent1);

                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        SpUtil spUtil = new SpUtil(this,"country_number");
        country_number.setText(spUtil.getString("countryNumber","null"));

    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        String numbver = "+86";
//        int postion = 0;
//        SpUtil spUtil = new SpUtil(this,"country_number");
//        spUtil.putString("countryNumber",numbver);
//        SpUtil spUtil2 = new SpUtil(this,"postion");
//        spUtil2.putInt("postion",postion);
//
//    }
}
