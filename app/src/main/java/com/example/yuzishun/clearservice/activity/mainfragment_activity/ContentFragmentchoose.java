package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.adapter.GridViewAdapterr;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.ServiceinfocationBean;
import com.example.yuzishun.clearservice.net.ApiMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by yuzishun on 2018/8/12.
 */

public class ContentFragmentchoose extends Fragment {

    private static final String KEY = "title";
    private GridView gridView;
    private String[] datas = new String[]{"08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30",};
    private GridViewAdapterr gridViewAdapter;
    private List<List<Integer>> data = new ArrayList<List<Integer>>();
    private List<String> datafu= new ArrayList<>();
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null) {
            view = View.inflate(getActivity(), R.layout.choose_item, null);
            gridView = view.findViewById(R.id.gridview);
            List<String> list = new ArrayList<>();
//        for (int i = 0; i < datas.length; i++) {
//            list.add(datas[i]);
//        }
            Bundle arguments = getArguments();
            datafu = arguments.getStringArrayList("xiaobiao");
            String id = arguments.getString("id");


            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("_id", id);

            Observer<ServiceinfocationBean> observer = new Observer<ServiceinfocationBean>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(ServiceinfocationBean serviceinfocationBean) {
                    Log.e("YZS", serviceinfocationBean.getData().toString());
                    if (serviceinfocationBean.getCode() == 200) {
                        serviceinfocationBean.getData().getService_detail_time();
                        for (int i = 0; i < datafu.size(); i++) {
                            data = serviceinfocationBean.getData().getService_detail_time();

                        }
//                    Log.e("YZS",datas.size()+"");
//                    for (int i = 0; i <datas.size() ; i++) {
////                       if(datas2.size()>5){
////
////                       }else {
//                        long ping_end = (int) datas2.get(i);
//                        String s = TimeUtils.getFetureDate(ping_end * 1000);
//                        datas.add(s);
////                       }
//                    }
//                    Log.e("YZS",datas.size()+""+datas.toString());


                        gridViewAdapter = new GridViewAdapterr(data, getContext(), datafu);

                        gridView.setAdapter(gridViewAdapter);
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                TextView textView = view.findViewById(R.id.textview);

                                Content.chooseTime = textView.getText().toString().trim();
                                Log.e("YZS", Content.chooseTime + "");
                                gridViewAdapter.clearSelection(position);
                                gridViewAdapter.notifyDataSetChanged();
                            }
                        });


                    } else {
                        Toast.makeText(getContext(), serviceinfocationBean.getMsg() + "", Toast.LENGTH_SHORT).show();
                    }


                }

                @Override
                public void onError(Throwable e) {
//                Toast.makeText(getContext(), "服务人员id有误", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onComplete() {

                }
            };

            ApiMethods.getServiceinfo(observer, hashMap);
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
    public static ContentFragmentchoose newInstance(ArrayList<String> datas, String id){
        ContentFragmentchoose fragment = new ContentFragmentchoose();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("xiaobiao",datas);
        bundle.putString("id",id);
        fragment.setArguments(bundle);

        return fragment;
    }

}
