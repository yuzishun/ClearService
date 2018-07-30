package com.example.yuzishun.clearservice.base;

import android.os.Bundle;

import com.example.yuzishun.clearservice.present.MvpPresenter;
import com.example.yuzishun.clearservice.present.MvpPresenterFragment;
import com.example.yuzishun.clearservice.present.MvpView;
import com.example.yuzishun.clearservice.present.MvpViewFragment;

/**
 * Created by yuzishun on 2018/7/30.
 */

public abstract  class BaseMvpFragment<P extends MvpPresenterFragment> extends Basefragment implements MvpViewFragment {
    protected P presenter;

    protected abstract P createPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }
        presenter.onMvpAttachView(this, savedInstanceState);
    }



    @Override
    public void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.onMvpStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.onMvpResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (presenter != null) {
            presenter.onMvpPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.onMvpStop();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (presenter != null) {
            presenter.onMvpSaveInstanceState(outState);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onMvpDetachView(false);
            presenter.onMvpDestroy();
        }
    }

}
