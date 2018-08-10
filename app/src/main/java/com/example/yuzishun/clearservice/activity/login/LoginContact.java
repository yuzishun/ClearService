package com.example.yuzishun.clearservice.activity.login;

import android.widget.Button;
import android.widget.CheckBox;

import com.example.yuzishun.clearservice.Custom.CEditText;
import com.example.yuzishun.clearservice.Custom.ClearEditText;
import com.example.yuzishun.clearservice.present.MvpPresenter;
import com.example.yuzishun.clearservice.present.MvpView;

/**
 * Created by yuzishun on 2018/7/31.
 */

public class LoginContact {

    public interface ILoginView extends MvpView{

    }
    public interface ILoginPresenter extends MvpPresenter<ILoginView>{
        //密码框的处理
        void PassWord(CEditText etPassword, CheckBox cbDisplayPassword);
        void login(ClearEditText user, CEditText password, LoginActivity loginActivity, Button login_button);
    }

}
