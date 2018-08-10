package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.adapter.listActivityAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuzishun on 2018/7/12.
 */

public class ContentFragment extends Fragment implements listActivityAdapter.OnRecyclerViewListener {

    private static final String KEY = "title";
    private RecyclerView RecyclerView;
    private listActivityAdapter listActivityAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.listactivityadapter_item,null);
        RecyclerView = view.findViewById(R.id.RecyclerView);
        RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("家庭保洁一小时" + i);
        }



        listActivityAdapter = new listActivityAdapter(getContext(),list);
        RecyclerView.setAdapter(listActivityAdapter);
        listActivityAdapter.setOnRecyclerViewListener(this);



        return view;
    }
    /**
     * fragment静态传值
     */
    public static ContentFragment newInstance(String str){
        ContentFragment fragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY,str);
        fragment.setArguments(bundle);

        return fragment;
    }
    //接口回调事件，点击每一个item
    @Override
    public void onItemClick(int position) {

        startActivity(new Intent(getContext(),DetailsActivity.class));

    }
}
