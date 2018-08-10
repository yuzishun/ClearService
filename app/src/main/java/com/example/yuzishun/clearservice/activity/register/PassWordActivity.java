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
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.utils.RegexUtils;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

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
                    //这里把账号和密码一起提交到服务器，返回success，则跳转到补充资料页面，，不成功，提示失败


                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }else {

                    Toast.makeText(this, "对不起，您的不密码不规范，密码必须包含大小写，不能少于六位，不能多于十六位", Toast.LENGTH_SHORT).show();
                }



                break;


        }
    }
}
