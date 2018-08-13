package com.example.yuzishun.clearservice.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/12.
 */

public class GridViewAdapterr extends BaseAdapter {

    private List<String> data;//数据

    private Context context;//上下文

    private int selectedPosition=0;
    public GridViewAdapterr(List<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public void clearSelection(int position) {
        selectedPosition = position;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        final ViewHolder viewHolder;
        if (convertView == null) {
            //加载子布局
            view = LayoutInflater.from(context).inflate(R.layout.gridview_choose_time_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = view.findViewById(R.id.textview);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(data.get(position));

//        if(position==0){
//            viewHolder.textView.setEnabled(true);
//
//        }else {
//            viewHolder.textView.setEnabled(false);
//        }
        if(selectedPosition==position){
            viewHolder.textView.setEnabled(true);
        }else{
            viewHolder.textView.setEnabled(false);
        }

        return view;
    }

    private class ViewHolder {
        Button textView;
    }
}