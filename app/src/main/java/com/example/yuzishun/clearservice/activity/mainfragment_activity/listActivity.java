package com.example.yuzishun.clearservice.activity.mainfragment_activity;

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
import com.example.yuzishun.clearservice.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class listActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.right_text)
    LinearLayout right_text;

    @BindView(R.id.quotation_tab)
    TabLayout tabLayout;

    @BindView(R.id.viewPager_list)
    ViewPager viewPager;
    private List<String> datas = new ArrayList<String>();//页卡标题集合
    private List<Fragment> fragments;

    @Override
    public int intiLayout() {
        return R.layout.activity_list;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String text = intent.getStringExtra("textname");
            title_text.setText(text);



        onclick();

    }
    private void onclick() {
        image_back.setOnClickListener(this);
    }


    @Override
    public void initData() {
        fragments = new ArrayList<>();
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
    public void initview() {


        datas.add("全部");
        datas.add("小时工");
        datas.add("日常保洁");
        datas.add("深度清洁");
        datas.add("开荒的人");
        datas.add("看不到布局");
        //tablayout 转换模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //在这里根据页面卡的长度，创建相对应的fragment
        for (int i = 0; i < datas.size(); i++) {
            ContentFragment fragment = ContentFragment.newInstance(datas.get(i));
            fragments.add(fragment);
        }

        for (int i = 0; i < datas.size(); i++) {

            tabLayout.addTab(tabLayout.newTab().setText(datas.get(i)));//添加tab选项

        }
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
