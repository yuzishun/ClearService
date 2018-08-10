package com.example.yuzishun.clearservice.activity.changename;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.Custom.CEditText;
import com.example.yuzishun.clearservice.Custom.CheckEditForButton;
import com.example.yuzishun.clearservice.Custom.EditTextChangeListener;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.login.LoginActivity;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.SettingActivity;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.langerActivity;
import com.example.yuzishun.clearservice.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.constraint.Constraints.TAG;

public class changepswActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.yuan_psw_ed)
    CEditText yuan_psw_ed;
    @BindView(R.id.new_psd_ed)
    CEditText new_psd_ed;
    @BindView(R.id.sure_button)
    Button sure_button;
    @BindView(R.id.cbDisplayPassword)
    CheckBox cbDisplayPassword;
    @Override
    public int intiLayout() {
        return R.layout.activity_changepsw;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);

        title_text.setText("修改密码");
        sure_button.setEnabled(false);

        PassWord();
        onclickc();
    }

    private void PassWord() {
        String yuanpsd=yuan_psw_ed.getText().toString().trim();
        String newpsd=new_psd_ed.getText().toString().trim();
        CheckEditForButton checkEditForButton = new CheckEditForButton(sure_button);
        checkEditForButton.addEditText(yuan_psw_ed, new_psd_ed);
        //3.根据接口回调的方法,分别进行操作
        checkEditForButton.setListener(new EditTextChangeListener() {
            @Override
            public void allHasContent(boolean isHasContent) {
                if (isHasContent) {
//                    if(regexUtils.isPassWord(password)==true && regexUtils.isPhone(user)==true){
                    sure_button.setEnabled(true);
//                    }
                } else {

                }
            }
        });
        cbDisplayPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged: "+isChecked);
                if(isChecked){
                    //选择状态 显示明文--设置为可见的密码
                    new_psd_ed.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                    new_psd_ed.setSelection(new_psd_ed.getText().length());
                } else {
                    //默认状态显示密码--设置文本 要一起写才能起作用 InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD
                    new_psd_ed.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    new_psd_ed.setSelection(new_psd_ed.getText().length());

                }
            }
        });
    }

    private void onclickc() {
        image_back.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        case R.id.image_back:
        finish();
        break;
        }

    }

}
