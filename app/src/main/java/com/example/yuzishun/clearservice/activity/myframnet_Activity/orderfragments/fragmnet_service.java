package com.example.yuzishun.clearservice.activity.myframnet_Activity.orderfragments;

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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.OrderdetailsActivity;
import com.example.yuzishun.clearservice.adapter.Adapter_orther;
import com.example.yuzishun.clearservice.adapter.listActivityAdapter;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.OrderBean;
import com.example.yuzishun.clearservice.net.ApiMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by yuzishun on 2018/8/23.
 */

public class fragmnet_service extends Fragment  {

    private RecyclerView RecyclerView;
    private Adapter_orther Adapter_orther;
    private LinearLayout layout_visit;
    private int state;
    private String title;
    private List<OrderBean.DataBean.ListBean> list = new ArrayList<>();
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null){
            view = View.inflate(getActivity(), R.layout.orther_item,null);


            RecyclerView = view.findViewById(R.id.RecyclerView);
            layout_visit = view.findViewById(R.id.layout_visit);
            RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


            HashMap<String,String> map = new HashMap<>();
            map.put("page","0");
            map.put("size","100");
            map.put("user_access_token", Content.Token);
            map.put("order_status","3");
            Observer<OrderBean> observer = new Observer<OrderBean>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(OrderBean orderBean) {
//                Log.e("YZS",orderBean.toString());
//                Log.e("YZS",orderBean.getData().toString());
                    if(orderBean.getData().getList().size()==0){
                        layout_visit.setVisibility(View.VISIBLE);
                        RecyclerView.setVisibility(View.GONE);
                    }else {


                        if (orderBean.getCode() == 200) {
                            list = orderBean.getData().getList();


                            Adapter_orther = new Adapter_orther(getContext(), list);
                            RecyclerView.setAdapter(Adapter_orther);
                            Adapter_orther.setOnRecyclerViewListener(new listActivityAdapter.OnRecyclerViewListener() {
                                @Override
                                public void onItemClick(int position) {
                                    Intent intent = new Intent(getContext(), OrderdetailsActivity.class);
                                    intent.putExtra("id", list.get(position).get_id());
                                    startActivity(intent);

                                }
                            });
//                    Adapter_orther.setOnRecyclerViewListener((listActivityAdapter.OnRecyclerViewListener) getContext());

                        } else {
                            Toast.makeText(getContext(), orderBean.getMsg() + "", Toast.LENGTH_SHORT).show();
                        }
                    }

                }

                @Override
                public void onError(Throwable e) {
                    Log.e("YZS",e.toString());

                }

                @Override
                public void onComplete() {

                }
            };

            ApiMethods.getOrder(observer,map);
            Log.e("YZS",map.toString());





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



}
