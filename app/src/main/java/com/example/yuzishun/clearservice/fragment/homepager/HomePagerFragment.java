package com.example.yuzishun.clearservice.fragment.homepager;


import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.Custom.MyViewPager;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.ContentFragment;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.DetailsActivity;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.MessageActivity;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.listActivity;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.ContentFragmenthome;
import com.example.yuzishun.clearservice.adapter.GridViewAdapter;
import com.example.yuzishun.clearservice.adapter.GridViewAdapter_home;
import com.example.yuzishun.clearservice.adapter.HP_ReAdapter;
import com.example.yuzishun.clearservice.adapter.ViewPagerAdapter_home;
import com.example.yuzishun.clearservice.adapter.listActivityAdapter;
import com.example.yuzishun.clearservice.base.BaseMvpFragment;
import com.example.yuzishun.clearservice.model.DataBean;
import com.example.yuzishun.clearservice.utils.indicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePagerFragment extends BaseMvpFragment<HomePagerContact.IHomePagerPresenter> implements HomePagerContact.IHomePagerView, com.example.yuzishun.clearservice.adapter.listActivityAdapter.OnRecyclerViewListener, View.OnClickListener {

    private HomePagerPresenterImpl mainPresenter;
    @BindView(R.id.homepager_tab)
    TabLayout tabLayout;
    @BindView(R.id.viewPager_list)
    MyViewPager viewPager;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.layout_richang)
    RelativeLayout layout_richang;
    @BindView(R.id.layout_clear)
    RelativeLayout layout_clear;
    @BindView(R.id.layout_huli)
    RelativeLayout layout_huli;
    @BindView(R.id.layout_youyan)
    RelativeLayout layout_youyan;
    @BindView(R.id.image_message)
    ImageView image_message;
    private listActivityAdapter listActivityAdapter;
    private List<String> datas = new ArrayList<String>();//页卡标题集合
    private List<Fragment> fragments;
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
        initview();
        onclick();
        initRecyclerview();
    }

    private void onclick() {
        layout_youyan.setOnClickListener(this);
        layout_huli.setOnClickListener(this);
        layout_clear.setOnClickListener(this);
        layout_richang.setOnClickListener(this);
        image_message.setOnClickListener(this);
    }


    @Override
    protected HomePagerContact.IHomePagerPresenter createPresenter() {
        return new HomePagerPresenterImpl();
    }


    public void initview(){

        datas.add("冰箱清洁");
        datas.add("空调清洗");

        fragments = new ArrayList<>();
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < datas.size(); i++) {
            ContentFragmenthome fragment = ContentFragmenthome.newInstance(datas.get(i));
            fragments.add(fragment);
        }
        for (int i = 0; i < datas.size(); i++) {

            tabLayout.addTab(tabLayout.newTab().setText(datas.get(i)));//添加tab选项

        }
        //fragment的适配器
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
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


    };
    private void initRecyclerview() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getMContext(),LinearLayoutManager.VERTICAL,false){


            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("家庭保洁一小时" + i);
        }
        recyclerview.setLayoutManager(linearLayoutManager);
        listActivityAdapter = new listActivityAdapter(getContext(),list);
        recyclerview.setAdapter(listActivityAdapter);
        listActivityAdapter.setOnRecyclerViewListener(this);




    }

    @Override
    public void onPause() {
        super.onPause();
        datas.clear();

    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(getContext(),DetailsActivity.class));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_richang:

                tiao();

                break;

            case R.id.layout_clear:
                tiao();


                break;
            case R.id.layout_huli:

                tiao();

                break;
            case R.id.layout_youyan:

                tiao();
                break;
            case R.id.image_message:
                startActivity(new Intent(getMContext(), MessageActivity.class));
                break;
        }

    }

    public void tiao(){
        startActivity(new Intent(getMContext(), listActivity.class));

    }
}
