package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.yuzishun.clearservice.Custom.MyScrollView;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderdetailsActivity extends BaseActivity implements View.OnClickListener, MyScrollView.OnScrollListener {
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.layout_title)
    RelativeLayout layout_title;
    @BindView(R.id.scroll_view)
    MyScrollView scroll_view;
    @Override
    public int intiLayout() {
        return R.layout.activity_orderdetails;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
//
        title_text.setText("订单详情");
        initState();
        onclick();
        scroll_view.setScrolListener(this);
    }

    private void onclick() {
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
    private void initState() {
        if(Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            //取消设置透明状态栏,使 ContentView 内容不再沉浸到状态栏下
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(getResources().getColor(R.color.blue2));
        }
    }

    @Override
    public void onScroll(int scrollY) {

    }
}
