package com.example.yuzishun.clearservice.fragment.homepager;

import android.view.View;
import android.widget.TextView;

import com.example.yuzishun.clearservice.present.BaseMvpPresenterFragment;


/**
 * Created by yuzishun on 2018/7/30.
 */

public class HomePagerPresenterImpl extends BaseMvpPresenterFragment<HomePagerContact.IHomePagerView> implements HomePagerContact.IHomePagerPresenter{

    @Override
    public void initView(final TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() {
             @Override
       public void onClick(View v) {
        textView.setText("你是我哥哥");
    }
});
    }
}
