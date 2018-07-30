package com.example.yuzishun.clearservice.fragment.homepager;

import android.widget.TextView;

import com.example.yuzishun.clearservice.present.MvpPresenterFragment;
import com.example.yuzishun.clearservice.present.MvpViewFragment;


/**
 * Created by yuzishun on 2018/7/30.
 */

public class HomePagerContact {
    public interface IHomePagerView extends MvpViewFragment{


    }
    public interface IHomePagerPresenter extends MvpPresenterFragment<IHomePagerView> {

        void initView(TextView textView);
    }
}
