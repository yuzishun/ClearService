package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.adapter.listActivityAdapter;
import com.example.yuzishun.clearservice.model.classBeantwosp;
import com.example.yuzishun.clearservice.model.classificationBean;
import com.example.yuzishun.clearservice.model.classificationvideoBean;
import com.example.yuzishun.clearservice.net.ApiMethods;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by yuzishun on 2018/7/12.
 */

public class ContentFragment extends Fragment implements listActivityAdapter.OnRecyclerViewListener {

    private static final String KEY = "title";
    private RecyclerView RecyclerView;
    private listActivityAdapter listActivityAdapter;
    private String _idone,_idtwo;
    private List<classificationvideoBean.DataBean.ListBean> listBeans = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.listactivityadapter_item,null);
        RecyclerView = view.findViewById(R.id.RecyclerView);
        RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        HashMap<String,String> hashMap = new HashMap<>();

        Bundle idlist = getArguments();
        _idone = idlist.getString("_idone");
        _idtwo = idlist.getString("_idtwo");

        hashMap.put("page","0");
        hashMap.put("size","10");
        hashMap.put("classify_branch_id",_idone);
        hashMap.put("classify_chlid_id",_idtwo);
        hashMap.put("order_by","1");

        Observer<classificationvideoBean> observer = new Observer<classificationvideoBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(classificationvideoBean classificationvideobean) {

                if(classificationvideobean.getCode()==200){

                    listBeans = classificationvideobean.getData().getList();



                    listActivityAdapter = new listActivityAdapter(getContext(),listBeans);
                    RecyclerView.setAdapter(listActivityAdapter);


                }




            }

            @Override
            public void onError(Throwable e) {
                Log.e("YZS",e.getMessage());
                Toast.makeText(getContext(), "参数错误,或者网络不稳定", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onComplete() {

            }
        };
        ApiMethods.getclassificationvideo(observer,hashMap);

        Log.e("YZS",hashMap.toString());







        return view;
    }
    /**
     * fragment静态传值
     */
    public static ContentFragment newInstance(String idone,String idtwo){
        ContentFragment fragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("_idone",idone);
        bundle.putString("_idtwo",idtwo);
        fragment.setArguments(bundle);

        return fragment;
    }
    //接口回调事件，点击每一个item
    @Override
    public void onItemClick(int position) {


    }
}
