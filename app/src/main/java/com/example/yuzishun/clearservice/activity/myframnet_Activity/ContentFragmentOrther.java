package com.example.yuzishun.clearservice.activity.myframnet_Activity;

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
import com.example.yuzishun.clearservice.activity.mainfragment_activity.DetailsActivity;
import com.example.yuzishun.clearservice.adapter.Adapter_orther;
import com.example.yuzishun.clearservice.adapter.listActivityAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuzishun on 2018/7/12.
 */

public class ContentFragmentOrther extends Fragment implements listActivityAdapter.OnRecyclerViewListener {

    private static final String KEY = "title";
    private RecyclerView RecyclerView;
    private Adapter_orther Adapter_orther;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.orther_item,null);
        RecyclerView = view.findViewById(R.id.RecyclerView);
        RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("拼团订单" + i);
        }



        Adapter_orther = new Adapter_orther(getContext(),list);
        RecyclerView.setAdapter(Adapter_orther);
        Adapter_orther.setOnRecyclerViewListener(this);



        return view;
    }
    /**
     * fragment静态传值
     */
    public static ContentFragmentOrther newInstance(String str){
        ContentFragmentOrther fragment = new ContentFragmentOrther();
        Bundle bundle = new Bundle();
        bundle.putString(KEY,str);
        fragment.setArguments(bundle);

        return fragment;
    }
    //接口回调事件，点击每一个item
    @Override
    public void onItemClick(int position) {

//        startActivity(new Intent(getContext(),DetailsActivity.class));
        

    }
}
