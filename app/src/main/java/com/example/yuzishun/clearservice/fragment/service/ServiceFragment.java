package com.example.yuzishun.clearservice.fragment.service;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.MessageActivity;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.listActivity;
import com.example.yuzishun.clearservice.adapter.GridViewAdapter_home;
import com.example.yuzishun.clearservice.adapter.HP_ReAdapter;
import com.example.yuzishun.clearservice.adapter.ViewPagerAdapter_home;
import com.example.yuzishun.clearservice.base.BaseMvpFragment;
import com.example.yuzishun.clearservice.fragment.homepager.HomePagerPresenterImpl;
import com.example.yuzishun.clearservice.model.DataBean;
import com.example.yuzishun.clearservice.present.MvpPresenterFragment;
import com.example.yuzishun.clearservice.utils.indicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceFragment extends BaseMvpFragment implements View.OnClickListener {
    private HomePagerPresenterImpl mainPresenter;
    public static int item_grid_num = 8;//每一页中GridView中item的数量
    public static int number_columns = 4;//gridview一行展示的数目
    @BindView(R.id.homePager_VirePager)
    ViewPager view_pager;
    @BindView(R.id.image_message)
    ImageView image_message;
    private ViewPagerAdapter_home mAdapter;
    private List<DataBean> dataList;
    private List<GridView> gridList = new ArrayList<>();
    private CirclePageIndicator indicator;
    private RecyclerView home_pager_RecyclerView;
    private List<String> list = new ArrayList<String>();
    private HP_ReAdapter hp_reAdapter;
    private int pageSize;

    private GridView gridView;
    GridViewAdapter_home adapter;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_service;
    }
    @Override
    protected void setUpView() {
        mainPresenter = new HomePagerPresenterImpl();
    }
    @Override
    protected void setUpData() {
        image_message.setOnClickListener(this);
        //视屏的adapter
        for (int i = 0; i < 5; i++) {
            list.add("28¥" + i);
        }
        initView();
        hp_reAdapter = new HP_ReAdapter(getMContext(), list);
        home_pager_RecyclerView.setAdapter(hp_reAdapter);
        home_pager_RecyclerView.setHasFixedSize(true);
        initDatas();
    }
    @Override
    protected MvpPresenterFragment createPresenter() {
        return new HomePagerPresenterImpl();
    }
    private void initDatas() {
        if (dataList.size() > 0) {
            dataList.clear();
        }
        if (gridList.size() > 0) {
            gridList.clear();
        }
        //初始化数据
        for (int i = 0; i < 10; i++) {
            DataBean bean = new DataBean();
            bean.name = "家庭保洁" + i;
            dataList.add(bean);
        }
        //计算viewpager一共显示几页
        pageSize = dataList.size() % item_grid_num == 0
                ? dataList.size() / item_grid_num
                : dataList.size() / item_grid_num + 1;
        for (int i = 0; i < pageSize; i++) {
            gridView = new GridView(getMContext());
            adapter = new GridViewAdapter_home(getMContext(), dataList, i);
            gridView.setNumColumns(number_columns);
            gridView.setHorizontalSpacing(20);
//            gridView.setGravity(Gravity.TOP);
            gridView.setAdapter(adapter);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getMContext(), listActivity.class);
                    TextView textView = view.findViewById(R.id.tv_text);
                    String text = textView.getText().toString().trim();
                    intent.putExtra("textname", text);
                    startActivity(intent);
                }
            });
            gridList.add(gridView);
        }
        mAdapter.add(gridList);
    }
    private void initView() {
        //初始化ViewPager

        mAdapter = new ViewPagerAdapter_home();
        view_pager.setAdapter(mAdapter);
        dataList = new ArrayList<>();
        home_pager_RecyclerView = getContentView().findViewById(R.id.home_pager_RecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getMContext(),LinearLayoutManager.VERTICAL,false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        home_pager_RecyclerView.setLayoutManager(linearLayoutManager);

        //圆点指示器
        indicator = (CirclePageIndicator) getContentView().findViewById(R.id.indicator);
        indicator.setVisibility(View.VISIBLE);
        indicator.setViewPager(view_pager);
    }
    public boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_message:
            startActivity(new Intent(getMContext(), MessageActivity.class));
            break;

        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hp_reAdapter.PauseStopVideo();
    }

    @Override
    public void onPause() {
        super.onPause();
        hp_reAdapter.PauseStopVideo();

    }

}
