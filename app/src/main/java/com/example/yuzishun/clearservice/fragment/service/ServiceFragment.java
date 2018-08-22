package com.example.yuzishun.clearservice.fragment.service;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.MessageActivity;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.listActivity;
import com.example.yuzishun.clearservice.adapter.GridViewAdapter_home;
import com.example.yuzishun.clearservice.adapter.HP_ReAdapter;
import com.example.yuzishun.clearservice.adapter.ViewPagerAdapter_home;
import com.example.yuzishun.clearservice.base.BaseMvpFragment;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.fragment.homepager.HomePagerPresenterImpl;
import com.example.yuzishun.clearservice.model.DataBean;
import com.example.yuzishun.clearservice.model.classificationBean;
import com.example.yuzishun.clearservice.model.classificationvideoBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.net.ApiService;
import com.example.yuzishun.clearservice.present.MvpPresenterFragment;
import com.example.yuzishun.clearservice.utils.indicator.CirclePageIndicator;
import com.google.gson.Gson;
import com.lcodecore.tkrefreshlayout.IBottomView;
import com.lcodecore.tkrefreshlayout.IHeaderView;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.GoogleDotView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceFragment extends BaseMvpFragment implements View.OnClickListener{
    private HomePagerPresenterImpl mainPresenter;
    public static int item_grid_num = 8;//每一页中GridView中item的数量
    public static int number_columns = 4;//gridview一行展示的数目
    @BindView(R.id.homePager_VirePager)
    ViewPager view_pager;
    @BindView(R.id.image_message)
    ImageView image_message;
    private ViewPagerAdapter_home mAdapter;
    private List<classificationBean.DataBean.ListBean> dataList;
    private List<GridView> gridList = new ArrayList<>();
    private CirclePageIndicator indicator;
    @BindView(R.id.twinkRefreshlayout)
    TwinklingRefreshLayout swipeRefrelayout;
    private int page=0,num=3;
    private RecyclerView home_pager_RecyclerView;
    private List<classificationvideoBean.DataBean.ListBean> list = new ArrayList<>();
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
        initView();
        netClass();
        netview(num);
        swipeRefrelayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                if(dataList.size()==0){
                    netClass();

                }else {
                    dataList.clear();
                    gridList.clear();
                    netClass();

                }
                try {

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refreshLayout.finishRefreshing();

            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                page++;
                num=num+3;
                netview(num);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refreshLayout.finishLoadmore();
            }
        });
//        swipeRefrelayout.setHeaderView(new GoogleDotView(getMContext()));

    }

    private void netview(int num) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("page","0");
        hashMap.put("size",num+"");
//        hashMap.put("action","homepage");
        Observer<classificationvideoBean> observer = new Observer<classificationvideoBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(classificationvideoBean classificationvideoBean) {
                Log.e("YZS",classificationvideoBean.getData().getList().toString());
                Log.e("YZS",classificationvideoBean.getData().toString());
                Log.e("YZS",classificationvideoBean.toString());

                if(classificationvideoBean.getCode()==200){




                classificationvideoBean.DataBean data = classificationvideoBean.getData();
                if(data!=null){
                    list = data.getList();
                        if(hp_reAdapter==null){
                            hp_reAdapter = new HP_ReAdapter(getMContext(), list);
                            home_pager_RecyclerView.setAdapter(hp_reAdapter);
                            home_pager_RecyclerView.setHasFixedSize(true);
                        }
                        else {

                            new Runnable(){
                                @Override
                                public void run() {
                                    hp_reAdapter.setData(list);

                                }
                            }.run();

                        }
                }
            }else {

                }

            }

            @Override
            public void onError(Throwable e) {
                Log.e("YZS",e.getMessage()+"");
                Toast.makeText(getMContext(), "暂无数据", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        };
        ApiMethods.getclassificationvideo(observer,hashMap);

        Log.e("YZS",hashMap.toString()+"");

    }



    private void netClass() {
        dataList = new ArrayList<>();
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("page","0");
        hashMap.put("size","10");
        hashMap.put("classify_branch_id","");
        hashMap.put("classify_type","1");

        //网络请求
        Observer<classificationBean> observer = new Observer<classificationBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(classificationBean classificationBean) {
                if(classificationBean.getData()!=null){
                    dataList = classificationBean.getData().getList();
                    initDatas();

                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("YZS",e.getMessage());
                Toast.makeText(getMContext(), "请求有误,请看具体原因", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        };
        ApiMethods.getclassifiction(observer,hashMap);
    }

    @Override
    protected MvpPresenterFragment createPresenter() {
        return new HomePagerPresenterImpl();
    }
    private void initDatas() {

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
                    intent.putExtra("_id",dataList.get(position).get_id());
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

//
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
