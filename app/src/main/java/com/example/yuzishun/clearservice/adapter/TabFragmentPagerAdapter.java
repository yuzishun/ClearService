package com.example.yuzishun.clearservice.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yuzishun on 2018/7/30.
 */

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    //继承FragmentPagerAdapter类 ,并自定义的构造器
    private List<Fragment> fragments;

    public TabFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}