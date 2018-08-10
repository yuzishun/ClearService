package com.example.yuzishun.clearservice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/2.
 */

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;
    public GridViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.gridview_item, null);
        Button button=    (Button) convertView.findViewById(R.id.button_crde);
        button.setText(list.get(position));
        return convertView;

    }


}

