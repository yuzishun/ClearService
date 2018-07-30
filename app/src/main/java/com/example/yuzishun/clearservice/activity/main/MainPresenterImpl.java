package com.example.yuzishun.clearservice.activity.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.yuzishun.clearservice.Custom.MyViewPager;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.main.MainContact;
import com.example.yuzishun.clearservice.adapter.TabFragmentPagerAdapter;
import com.example.yuzishun.clearservice.fragment.homepager.HomePagerFragment;
import com.example.yuzishun.clearservice.fragment.msg.MsgFragment;
import com.example.yuzishun.clearservice.fragment.my.MyFragment;
import com.example.yuzishun.clearservice.present.BaseMvpPresenter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yuzishun on 2018/7/30.
 */

public class MainPresenterImpl extends BaseMvpPresenter<MainContact.IMainView> implements MainContact.IMainPresenter {
    private TabFragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments;

    private RadioButton[] radioButtons;


    @Override
    public void Total(final MyViewPager myViewPager, RadioGroup radioGroup, android.support.v4.app.FragmentManager fragmentManager) {

        radioButtons = new RadioButton[radioGroup.getChildCount()];
        for (int i = 0; i <radioButtons.length ; i++) {
            radioButtons[i] = (RadioButton) radioGroup.getChildAt(i);

        }
        mFragments = new ArrayList<Fragment>();
        Fragment mTab_01 = new HomePagerFragment();
        Fragment mTab_02 = new MsgFragment();
        Fragment mTab_03 = new MyFragment();

        radioButtons[0].setChecked(true);
        mFragments.add(mTab_01);
        mFragments.add(mTab_02);
        mFragments.add(mTab_03);

        mAdapter = new TabFragmentPagerAdapter(fragmentManager, mFragments);
        myViewPager.setAdapter(mAdapter);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i) {
                    case R.id.id_tab_01:
                        myViewPager.setCurrentItem(0,false);
                        break;
                    case R.id.id_tab_02:
                        myViewPager.setCurrentItem(1,false);
                        break;
                    case R.id.id_tab_03:
                        myViewPager.setCurrentItem(2,false);
                        break;

                }


            }
        });

        myViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioButtons[position].setChecked(true);


            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });
    }
}