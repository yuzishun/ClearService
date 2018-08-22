package com.example.yuzishun.clearservice.activity.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.Custom.CEditText;
import com.example.yuzishun.clearservice.Custom.CheckEditForButton;
import com.example.yuzishun.clearservice.Custom.ClearEditText;
import com.example.yuzishun.clearservice.Custom.EditTextChangeListener;
import com.example.yuzishun.clearservice.MainActivity;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.forget.PhotoActivity;
import com.example.yuzishun.clearservice.activity.register.RegisterActivity;
import com.example.yuzishun.clearservice.base.BaseMvpActivity;
import com.example.yuzishun.clearservice.present.MvpPresenter;
import com.example.yuzishun.clearservice.tools.CountryActivity;
import com.example.yuzishun.clearservice.utils.RegexUtils;
import com.example.yuzishun.clearservice.utils.SpUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseMvpActivity implements View.OnClickListener {
    @BindView(R.id.etPassword)
    CEditText etPassword;
    @BindView(R.id.cbDisplayPassword)
    CheckBox cbDisplayPassword;
    @BindView(R.id.photo)
    ClearEditText photo;
    @BindView(R.id.NewUser)
    TextView NewUser;
    @BindView(R.id.Forget_id)
    TextView Forget_id;
    @BindView(R.id.button_login)
    Button button_login;
    private LoginPresenterImpl presenter;
    private String password,user;
    private RegexUtils regexUtils;
    @BindView(R.id.layout_country)
    LinearLayout layout_country;
    @BindView(R.id.country_number)
    TextView country_number;
    public static LoginActivity instance;
    @Override
    public int intiLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        presenter = new LoginPresenterImpl();
        instance = this;

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void initData() {
        button_login.setEnabled(false);
        presenter.PassWord(etPassword,cbDisplayPassword);
        presenter.login(photo,etPassword,this,button_login);
        password = etPassword.getText().toString().trim();

        user = photo.getText().toString().trim();
        regexUtils = new RegexUtils(this);
        layout_country.setOnClickListener(this);
        CheckEditForButton checkEditForButton = new CheckEditForButton(button_login);
        checkEditForButton.addEditText(etPassword, photo);
        //3.根据接口回调的方法,分别进行操作
        checkEditForButton.setListener(new EditTextChangeListener() {
            @Override
            public void allHasContent(boolean isHasContent) {
                if (isHasContent) {
//                    if(regexUtils.isPassWord(password)==true && regexUtils.isPhone(user)==true){
                        button_login.setEnabled(true);
//                    }
                } else {

                }
            }
        });


        NewUser.setOnClickListener(this);
        Forget_id.setOnClickListener(this);
    }

    @Override
    protected MvpPresenter createPresenter() {
        return new LoginPresenterImpl();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.NewUser:
                //跳转到注册页面
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);

                break;
            case R.id.Forget_id:
                //跳转到忘记密码页面
                Intent intent2 = new Intent(this, PhotoActivity.class);
                startActivity(intent2);
                break;

            case R.id.layout_country:

                Intent intent1 = new Intent(LoginActivity.this, CountryActivity.class);
                intent1.putExtra("country_number",country_number.getText().toString().trim());
                startActivity(intent1);


                break;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        SpUtil spUtil = new SpUtil(LoginActivity.this,"country_number");
        country_number.setText(spUtil.getString("countryNumber","null"));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String numbver = "+86";
        int postion = 0;
        SpUtil spUtil = new SpUtil(LoginActivity.this,"country_number");
        spUtil.putString("countryNumber",numbver);
        SpUtil spUtil2 = new SpUtil(LoginActivity.this,"postion");
        spUtil2.putInt("postion",postion);

    }
}

