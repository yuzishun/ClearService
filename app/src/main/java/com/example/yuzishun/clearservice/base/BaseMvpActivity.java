package com.example.yuzishun.clearservice.base;

import android.app.Activity;
import android.os.Bundle;

import com.example.yuzishun.clearservice.present.MvpPresenter;
import com.example.yuzishun.clearservice.present.MvpView;

/**
 * Created by yuzishun on 2018/7/30.
 */
//封装好的mvp的基类，所有逻辑多的页面，都用他来实现
public abstract class BaseMvpActivity<P extends MvpPresenter> extends BaseActivity implements MvpView {

    protected P presenter;
    protected Activity mActivity;
    protected abstract P createPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }
        mActivity = this;
        presenter.onMvpAttachView(this, savedInstanceState);
    }



    @Override
    protected void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.onMvpStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.onMvpResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (presenter != null) {
            presenter.onMvpPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.onMvpStop();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (presenter != null) {
            presenter.onMvpSaveInstanceState(outState);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onMvpDetachView(false);
            presenter.onMvpDestroy();
        }
    }

}
