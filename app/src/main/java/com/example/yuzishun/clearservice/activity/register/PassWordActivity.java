package com.example.yuzishun.clearservice.activity.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.Custom.CheckEditForButton;
import com.example.yuzishun.clearservice.Custom.ClearEditText;
import com.example.yuzishun.clearservice.Custom.EditTextChangeListener;
import com.example.yuzishun.clearservice.MainActivity;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.information.InformationActivity;
import com.example.yuzishun.clearservice.activity.login.LoginActivity;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.codeBean;
import com.example.yuzishun.clearservice.model.regiserBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.utils.MD5Util;
import com.example.yuzishun.clearservice.utils.RegexUtils;
import com.example.yuzishun.clearservice.utils.SpUtil;

import java.util.HashMap;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static android.support.constraint.Constraints.TAG;

public class PassWordActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.cbDisplayPassword)
    CheckBox mCbDisplay;
    @BindView(R.id.Clear_Edittext)
    ClearEditText clearEditText;
    @BindView(R.id.button_getResule)
    Button mButton_getResule;
    @BindView(R.id.text_back)
    ImageView mText_back;
    private String number;
    private RegexUtils regexUtils;
    @Override
    public int intiLayout() {
        return R.layout.activity_pass_word;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        mButton_getResule.setEnabled(false);

        mButton_getResule.setOnClickListener(this);
        mText_back.setOnClickListener(this);
        regexUtils = new RegexUtils(this);
        clearEditText.setFocusable(true);
        clearEditText.setFocusableInTouchMode(true);
        clearEditText.requestFocus();
        Intent intent = getIntent();
        number =intent.getStringExtra("number");
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        CheckEditForButton checkEditForButton = new CheckEditForButton(mButton_getResule);
        checkEditForButton.addEditText(clearEditText);
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



        mCbDisplay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged: "+isChecked);
                if(isChecked){
                    //选择状态 显示明文--设置为可见的密码
                    clearEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                    clearEditText.setSelection(clearEditText.getText().length());
                } else {
                    //默认状态显示密码--设置文本 要一起写才能起作用 InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD
                    clearEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    clearEditText.setSelection(clearEditText.getText().length());

                }
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
                String pw = clearEditText.getText().toString().trim();
                //true是规范的密码
                if(regexUtils.isPassWord(pw)==true){

                    SpUtil spUtil = new SpUtil(PassWordActivity.this,"country_number");


                    //这里把账号和密码一起提交到服务器，返回success，则跳转到补充资料页面，，不成功，提示失败
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("phone",number);
                    hashMap.put("password",MD5Util.encrypt(pw));
                    hashMap.put("area_number",spUtil.getString("countryNumber","null"));
                    hashMap.put("nickname","用户"+number);

                    Observer<regiserBean> observer = new Observer<regiserBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(regiserBean regiserbean) {
                            if(regiserbean.getCode()==200){

                                Toast.makeText(PassWordActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                SpUtil spUtil = new SpUtil(PassWordActivity.this, "file");
                                Content.Token = regiserbean.getData().getToken();
                                spUtil.putString("login", regiserbean.getData().getToken());
                                Intent intent = new Intent(PassWordActivity.this, MainActivity.class);
                                SpUtil spUtil1 = new SpUtil(PassWordActivity.this,"Userid");
                                spUtil1.putString("User_id",regiserbean.getData().get_id());
                                startActivity(intent);
                                LoginActivity.instance.finish();
                                finish();
                            }else {

                                Toast.makeText(PassWordActivity.this, regiserbean.getMsg()+"", Toast.LENGTH_SHORT).show();

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
                    ApiMethods.getRegister(observer,hashMap);





                }else {

                    Toast.makeText(this, "对不起，您的不密码不规范，密码必须包含大小写，不能少于六位，不能多于十六位", Toast.LENGTH_SHORT).show();
                }



                break;


        }
    }
}
