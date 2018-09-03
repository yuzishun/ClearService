package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.ContentFragment;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.orderfragments.fragment_finish;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.orderfragments.fragment_servicez;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.orderfragments.fragment_tuan;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.orderfragments.fragmnet_service;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.orderfragments.framgnet_paid;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.base.Content;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrtherActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.tab_orther)
    TabLayout tabLayout;
    private String index;
    @BindView(R.id.viewPager_orther)
    ViewPager viewPager;
    private List<String> datas = new ArrayList<String>();//页卡标题集合
    private List<Fragment> fragments;
    @Override
    public int intiLayout() {
        return R.layout.activity_orther;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        Intent intent = getIntent();
        index = intent.getStringExtra("index");

        title_text.setText("我的订单");
        onclick();

    }

    private void onclick() {
        image_back.setOnClickListener(this);

    }

    @Override
    public void initData() {

        fragments = new ArrayList<>();
        datas.add("全部");
        datas.add("待支付");
        datas.add("待成团");
        datas.add("待服务");
        datas.add("服务中");
        datas.add("已完成");
        for (int i = 0; i < datas.size(); i++) {

            tabLayout.addTab(tabLayout.newTab().setText(datas.get(i)));//添加tab选项

        }

        //tablayout 转换模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
//        for (int i = 0; i < datas.size(); i++) {
//
//            fragments.add(fragment);
//        }
        fragments.add(new ContentFragmentOrther());
        fragments.add(new framgnet_paid());
        fragments.add(new fragment_tuan());
        fragments.add(new fragmnet_service());
        fragments.add(new fragment_servicez());
        fragments.add(new fragment_finish());


        initview();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:

                finish();
                break;

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        try {

//        tabLayout.getTabAt(index).select();
            viewPager.setCurrentItem(Integer.parseInt(index));
            index="";
        }catch (Exception e){


        }

    }

    private void initview() {




//fragment的适配器
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
            @Override
            public CharSequence getPageTitle(int position) {
                return datas.get(position);
            }

        };

        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
//        quotation_tab.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
//        datas.clear();



    }

    @Override
    public void onPause() {
        super.onPause();
        datas.clear();
    }

}
