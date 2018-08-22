package com.example.yuzishun.clearservice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.model.LocationInfo;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/21.
 */

public class telfjAdapter extends RecyclerView.Adapter<telfjAdapter.ViewHolder> {
    private Context context;
    private List<LocationInfo> data;

    public telfjAdapter(Context context, List<LocationInfo> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public telfjAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_fjadap_item,parent,false));
    }

    @Override
    public void onBindViewHolder(telfjAdapter.ViewHolder holder, int position) {
        holder.name.setText(data.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
