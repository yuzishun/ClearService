package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.adapter.GridViewAdapter;
import com.example.yuzishun.clearservice.adapter.GridViewAdapterr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuzishun on 2018/8/12.
 */

public class ContentFragmentchoose extends Fragment {

    private static final String KEY = "title";
    private GridView gridView;
    private String[] datas = new String[]{"08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30",};
    private GridViewAdapterr gridViewAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.choose_item,null);
        gridView = view.findViewById(R.id.gridview);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < datas.length; i++) {
            list.add(datas[i]);
        }


        gridViewAdapter = new GridViewAdapterr(list,getContext());

        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(getContext(), position+"", Toast.LENGTH_SHORT).show();
                gridViewAdapter.clearSelection(position);
                gridViewAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
    /**
     * fragment静态传值
     */
    public static ContentFragmentchoose newInstance(String str){
        ContentFragmentchoose fragment = new ContentFragmentchoose();
        Bundle bundle = new Bundle();
        bundle.putString(KEY,str);
        fragment.setArguments(bundle);

        return fragment;
    }

}
