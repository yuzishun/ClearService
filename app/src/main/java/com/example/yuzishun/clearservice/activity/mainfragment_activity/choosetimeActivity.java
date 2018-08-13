package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class choosetimeActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.teablayout)
    TabLayout tabLayout;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.suer)
    Button sure;
    private String tiem;
    private List<String> datas = new ArrayList<String>();//页卡标题集合

    private List<Fragment> fragments;

    @Override
    public int intiLayout() {
        return R.layout.activity_choosetime;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_text.setText("选择服务时间");
        image_back.setOnClickListener(this);
        sure.setOnClickListener(this);
    }

    @Override
    public void initData() {
        fragments = new ArrayList<>();
        DateUtils dateUtils = new DateUtils();
        datas = dateUtils.getSevendate();
        for (int i = 0; i <datas.size() ; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(datas.get(i)));//添加tab选项

        }

        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < datas.size(); i++) {
            ContentFragmentchoose fragment = ContentFragmentchoose.newInstance(datas.get(i));
            fragments.add(fragment);
        }
        initview();


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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:
                finish();
                break;
            case R.id.suer:
                int currentItem = viewPager.getCurrentItem();
                String s = datas.get(currentItem);
                Fragment fragment = fragments.get(currentItem);
                GridView gridView = fragment.getView().findViewById(R.id.gridview);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Button button = view.findViewById(R.id.textview);
                        tiem = button.getText().toString().trim();

                    }
                });
                Toast.makeText(this, s+tiem+"", Toast.LENGTH_SHORT).show();

                finish();
                break;

        }
    }
    @Override
    public void onPause() {
        super.onPause();
        datas.clear();
    }
}
