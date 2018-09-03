package com.example.yuzishun.clearservice.activity.login;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.yuzishun.clearservice.Custom.CEditText;
import com.example.yuzishun.clearservice.Custom.ClearEditText;
import com.example.yuzishun.clearservice.MainActivity;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.register.CodeActivity;
import com.example.yuzishun.clearservice.activity.register.RegisterActivity;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.LoginBean;
import com.example.yuzishun.clearservice.model.codeBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.present.BaseMvpPresenter;
import com.example.yuzishun.clearservice.utils.MD5Util;
import com.example.yuzishun.clearservice.utils.RegexUtils;
import com.example.yuzishun.clearservice.utils.SpUtil;

import java.net.PasswordAuthentication;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static android.support.constraint.Constraints.TAG;
import static com.example.yuzishun.clearservice.utils.CommonHelper.dp2px;

/**
 * Created by yuzishun on 2018/7/31.
 */

public class LoginPresenterImpl extends BaseMvpPresenter<LoginContact.ILoginView> implements LoginContact.ILoginPresenter {

    private int logining=0;
    private RegexUtils regexUtils;
    @Override
    public void PassWord(final CEditText etPassword, CheckBox cbDisplayPassword) {

        cbDisplayPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged: "+isChecked);
                if(isChecked){
                    //选择状态 显示明文--设置为可见的密码
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                    etPassword.setSelection(etPassword.getText().length());
                } else {
                    //默认状态显示密码--设置文本 要一起写才能起作用 InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    etPassword.setSelection(etPassword.getText().length());

                }
            }
        });




    }

    @Override
    public void login(final ClearEditText user, final CEditText password, final LoginActivity loginActivity, final Button login_button) {
        regexUtils = new RegexUtils(loginActivity);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String passwordid = password.getText().toString().trim();
                 String userid = user.getText().toString().trim();

                 if(userid.equals("") || passwordid.equals("")){
                     Toast.makeText(loginActivity, "账号或者密码不能为空", Toast.LENGTH_SHORT).show();

                 }else {


                     if (regexUtils.isPhone(userid)==false) {
                         Toast.makeText(loginActivity, "手机号不符合格式请重新输入", Toast.LENGTH_SHORT).show();


                     } else {

                         if(regexUtils.isPassWord(passwordid)==true){
                             String encrypt = MD5Util.encrypt(passwordid);
                             SpUtil spUtil = new SpUtil(loginActivity,"country_number");
                             String country_number = spUtil.getString("countryNumber", "null");
                             HashMap<String,String> hashMap = new HashMap<>();
                             hashMap.put("phone",userid);
                             hashMap.put("password",encrypt);
                             hashMap.put("area_number",country_number);

                             Observer<LoginBean> observer = new Observer<LoginBean>() {
                                 @Override
                                 public void onSubscribe(Disposable d) {

                                 }

                                 @Override
                                 public void onNext(LoginBean loginBean) {
                                     Log.e("YZS",loginBean.toString());
                                     if(loginBean.getCode()==200){
                                         Toast.makeText(loginActivity, "登录成功", Toast.LENGTH_SHORT).show();
                                         SpUtil spUtil = new SpUtil(loginActivity, "file");
                                         Content.Token = loginBean.getData().getToken();
                                         spUtil.putString("login", loginBean.getData().getToken());
                                         SpUtil spUtil1 = new SpUtil(loginActivity,"Userid");
                                         spUtil1.putString("User_id",loginBean.getData().get_id());
                                         Intent intent = new Intent(loginActivity, MainActivity.class);
                                         loginActivity.startActivity(intent);

                                         loginActivity.finish();

                                     }else {
                                         Toast.makeText(loginActivity, loginBean.getMsg()+"", Toast.LENGTH_SHORT).show();

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
                             ApiMethods.getlogin(observer,hashMap);
                        Log.e("YZS",hashMap.toString());


                         }else {

                             Toast.makeText(loginActivity, "对不起，您的不密码不规范，密码必须包含大小写，不能少于六位，不能多于十六位", Toast.LENGTH_SHORT).show();

                         }



                     }
                 }
            }
        });

        
    }



}
