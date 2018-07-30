package com.example.yuzishun.clearservice.fragment.my;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.main.MainPresenterImpl;
import com.example.yuzishun.clearservice.base.BaseMvpFragment;
import com.example.yuzishun.clearservice.fragment.homepager.HomePagerPresenterImpl;
import com.example.yuzishun.clearservice.present.MvpPresenter;
import com.example.yuzishun.clearservice.present.MvpPresenterFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseMvpFragment {




    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_my;
    }

    @Override
    protected void setUpView() {

    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected MvpPresenterFragment createPresenter() {
        return new HomePagerPresenterImpl();
    }
}
