package com.example.yuzishun.clearservice.activity.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.Custom.CheckEditForButton;
import com.example.yuzishun.clearservice.Custom.ClearEditText;
import com.example.yuzishun.clearservice.Custom.EditTextChangeListener;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.login.LoginActivity;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.model.codeBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.tools.CountryActivity;
import com.example.yuzishun.clearservice.utils.RegexUtils;
import com.example.yuzishun.clearservice.utils.SpUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.text_back)
    ImageView mText_back;
    @BindView(R.id.photo_number)
    ClearEditText mPhoto_number;
    @BindView(R.id.button_getResule)
    Button mButton_getResule;
    @BindView(R.id.check_tel)
    CheckBox check_tel;
    @BindView(R.id.layout_country)
    LinearLayout layout_country;
    @BindView(R.id.country_number)
    TextView country_number;
    @BindView(R.id.text_ala)
    TextView text_ala;
    private RegexUtils regexUtils;
    private int i=0;
    @Override
    public int intiLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        mText_back.setOnClickListener(this);
        mButton_getResule.setOnClickListener(this);
        regexUtils = new RegexUtils(this);
        text_ala.setOnClickListener(this);
        layout_country.setOnClickListener(this);
        mPhoto_number.setFocusable(true);
        mPhoto_number.setFocusableInTouchMode(true);
        mPhoto_number.requestFocus();
            final CheckEditForButton checkEditForButton = new CheckEditForButton(mButton_getResule);
            checkEditForButton.addEditText(mPhoto_number);
            checkEditForButton.setListener(new EditTextChangeListener() {
                @Override
                public void allHasContent(boolean isHasContent) {
                    if (isHasContent) {
//                    if(regexUtils.isPassWord(password)==true && regexUtils.isPhone(user)==true){
                        if(i==1&&!mPhoto_number.getText().toString().trim().equals("")){
                            mButton_getResule.setEnabled(true);
                        }else {
                            mButton_getResule.setEnabled(false);

                        }

//                    }
                    } else {

                    }
                }
            });

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        check_tel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if(isChecked){

                    mButton_getResule.setEnabled(true);
                       i =1;



                }else{
                    i=0;
                    mButton_getResule.setEnabled(false);
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
                        hashMap.put("sms_type","1");
                        Observer<codeBean> observer = new Observer<codeBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(codeBean codebean) {
                                Log.e("YZS",codebean.getCode()+"");
                                Log.e("YZS",codebean.getMsg()+"");

                                if(codebean.getCode()==200){
                                    Intent intent = new Intent(RegisterActivity.this, CodeActivity.class);
                                    intent.putExtra("number", number);
                                    startActivity(intent);
                                    finish();

                                }else {
                                    Toast.makeText(RegisterActivity.this, codebean.getMsg()+"", Toast.LENGTH_SHORT).show();

                                }



                            }

                            @Override
                            public void onError(Throwable e) {

//                                ResponseBody responseBody = ((HttpException) e).response().errorBody();
//                                try {
//                                    if(responseBody!=null){
//
//                                        Log.e("YZS",responseBody.string().toString());
//                                    }
//
//                                }catch (Exception e1){
//
//                                }
//
//                                Toast.makeText(RegisterActivity.this, "发送失败，可能是网络原因，或者是手机号不正确", Toast.LENGTH_SHORT).show();

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
                Intent intent1 = new Intent(RegisterActivity.this, CountryActivity.class);
                intent1.putExtra("country_number",country_number.getText().toString().trim());
                startActivity(intent1);

                break;
            case R.id.text_ala:
                startActivity(new Intent(this,AgreementActivity.class));

                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        SpUtil spUtil = new SpUtil(RegisterActivity.this,"country_number");
        country_number.setText(spUtil.getString("countryNumber","null"));

    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        String numbver = "+86";
//        int postion = 0;
//        SpUtil spUtil = new SpUtil(RegisterActivity.this,"country_number");
//        spUtil.putString("countryNumber",numbver);
//        SpUtil spUtil2 = new SpUtil(RegisterActivity.this,"postion");
//        spUtil2.putInt("postion",postion);
//
//    }


}
