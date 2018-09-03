package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.DetailsActivity;
import com.example.yuzishun.clearservice.adapter.listActivityAdapter;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.HomepagerRecommend;
import com.example.yuzishun.clearservice.net.ApiMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by yuzishun on 2018/7/12.
 */

public class ContentFragmenthome extends Fragment {

    private static final String KEY = "title";
    private RecyclerView RecyclerView;
    private LinearLayout layout_visite;
    private HorizontalScrollView scrollview;
    private homeListAdapter homeListAdapter;
    private View view;
    private List<HomepagerRecommend.DataBean.ServiceListBean> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view ==null) {
            view = View.inflate(getActivity(), R.layout.content_homepager, null);
            RecyclerView = view.findViewById(R.id.RecyclerView);
            layout_visite = view.findViewById(R.id.layout_visite);
            scrollview = view.findViewById(R.id.scrollview);
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);

            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("user_access_token", Content.Token);

            Observer<HomepagerRecommend> observer = new Observer<HomepagerRecommend>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(final HomepagerRecommend homepagerRecommend) {

                    if (homepagerRecommend.getCode() == 200) {
                        for (int i = 0; i < homepagerRecommend.getData().size(); i++) {
                            list = homepagerRecommend.getData().get(i).getServiceList();

                        }
                        if(list.size()==0){
                            layout_visite.setVisibility(View.VISIBLE);
                            scrollview.setVisibility(View.GONE);
                        }else {
                            layout_visite.setVisibility(View.GONE);
                            scrollview.setVisibility(View.VISIBLE);
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false) {
                                @Override
                                public boolean canScrollVertically() {
                                    return false;
                                }
                            };
                            RecyclerView.setLayoutManager(linearLayoutManager);
                            homeListAdapter = new homeListAdapter(getContext(), list);
                            RecyclerView.setAdapter(homeListAdapter);

                            homeListAdapter.setOnRecyclerViewListener(new listActivityAdapter.OnRecyclerViewListener() {
                                @Override
                                public void onItemClick(int position) {
                                    Intent intent = new Intent(getContext(), DetailsActivity.class);
                                    intent.putExtra("id", list.get(position).get_id());
                                    startActivity(intent);

                                }
                            });

                        }
                    } else {
                        Toast.makeText(getContext(), homepagerRecommend.getMsg() + "", Toast.LENGTH_SHORT).show();
                    }

                }
                @Override
                public void onError(Throwable e) {
                    Log.e("YZS",e.getMessage());


                }

                @Override
                public void onComplete() {

                }
            };
            ApiMethods.getHomePageReco(observer,hashMap);



        }
        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            if (view != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
        }catch (Exception e){

        }


    }
    /**
     * fragment静态传值
     */
    public static ContentFragmenthome newInstance(){
        ContentFragmenthome fragment = new ContentFragmenthome();
        return fragment;
    }

}
