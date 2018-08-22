package com.example.yuzishun.clearservice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.model.addressBean;

import java.util.List;

/**
 * Created by yuzishun on 2018/8/7.
 */

public class telAdapternobeyond extends RecyclerView.Adapter<telAdapternobeyond.ViewHolder> {
    private Context mContext;
    private List<addressBean.DataBean.ListBean> list;

    public telAdapternobeyond(Context mContext, List<addressBean.DataBean.ListBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public telAdapternobeyond.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.nobeyondrv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(telAdapternobeyond.ViewHolder holder, int position) {

        try {


        holder.name.setText(list.get(position).getUser_name());
        holder.tel_number.setText(list.get(position).getMobile_phone()+"");

        holder.text_tel_.setText(list.get(position).getAddress_city()+""+list.get(position).getAddress_name()+""+list.get(position).getAddress_info());
        }catch (Exception e){

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,tel_number,text_tel_;


        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tel_name);
            tel_number = itemView.findViewById(R.id.tel_number);
            text_tel_ = itemView.findViewById(R.id.text_tel_);

        }
    }
}
