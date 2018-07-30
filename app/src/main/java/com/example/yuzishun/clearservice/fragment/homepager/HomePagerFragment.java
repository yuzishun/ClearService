package com.example.yuzishun.clearservice.fragment.homepager;


import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.main.MainPresenterImpl;
import com.example.yuzishun.clearservice.base.BaseMvpFragment;
import com.example.yuzishun.clearservice.present.MvpPresenter;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePagerFragment extends BaseMvpFragment<HomePagerContact.IHomePagerPresenter> implements HomePagerContact.IHomePagerView {
    @BindView(R.id.ceshi2)
    TextView ceshi2;
    private HomePagerPresenterImpl mainPresenter;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home_pager;

    }

    @Override
    protected void setUpView() {
        mainPresenter = new HomePagerPresenterImpl();
    }

    @Override
    protected void setUpData() {
    mainPresenter.initView(ceshi2);
    }


    @Override
    protected HomePagerContact.IHomePagerPresenter createPresenter() {
        return new HomePagerPresenterImpl();
    }
}
