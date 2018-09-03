package com.example.yuzishun.clearservice.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yuzishun.clearservice.Custom.ClearEditText;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.AddtelActivity;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.Bean;
import com.example.yuzishun.clearservice.model.addressBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yuzishun on 2018/8/3.
 */

public class RecyclerViewTel_Adapter  extends RecyclerView.Adapter<RecyclerViewTel_Adapter.ViewHolder> {
    private Context mContext;
    private List<Bean> mDatas;
    private List<addressBean.DataBean.ListBean> list;
    public RecyclerViewTel_Adapter(Context mContext, List<addressBean.DataBean.ListBean> list,List<Bean> mDatas) {
        this.mContext = mContext;
        this.list = list;
        this.mDatas = mDatas;
    }
    // 采用接口回调的方式实现RecyclerView的ItemClick
    public listActivityAdapter.OnRecyclerViewListener mOnRecyclerViewListener;


    // 接口回调第一步: 定义接口和接口中的方法
    public interface OnRecyclerViewListener {

        void onItemClick(int position);

    }
    // 接口回调第二步: 初始化接口的引用
    public void setOnRecyclerViewListener(listActivityAdapter.OnRecyclerViewListener l) {
        this.mOnRecyclerViewListener = l;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item_tel, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewTel_Adapter.ViewHolder holder, final int position) {

        if(list!=null){
            holder.text_name_tel.setText(list.get(position).getAddress_city());

        }else {

        }

        holder.text_name_tel.setText(list.get(position).getUser_name());
        holder.tel_phone.setText(list.get(position).getMobile_phone()+"");

        holder.tel_text.setText(list.get(position).getAddress_name());
        holder.layout_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,AddtelActivity.class);
                Content.choosetel=1;
                intent.putExtra("id",list.get(position).get_id());
                mContext.startActivity(intent);


            }
        });


                if(mDatas.get(position).isChecked()){
                    holder.text_tel.setText("默认地址");
                    holder.checkBox_tel.setChecked(true);
                }else {
                    holder.checkBox_tel.setChecked(false);
                    holder.text_tel.setText("设置默认");

                }

        holder.checkBox_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnRecyclerViewListener != null) {
                    mOnRecyclerViewListener.onItemClick(position);
                }
            }
        });



//        holder.checkBox_tel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//
//                    checkedPosition = position;
//
//
//                }else {
//
//
//                }
//                if(checkedPosition==position){
//                    holder.checkBox_tel.setChecked(true);
//
//                }else {
//                    holder.checkBox_tel.setChecked(false);
//                }
//
//            }
//        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    //  删除数据
    public void removeData(int position) {
        list.remove(position);
        //删除动画
        notifyItemRemoved(position);

        notifyDataSetChanged();


    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkBox_tel;
        private TextView text_name_tel,text_tel,tel_text,tel_phone;

        private LinearLayout layout_remove,layout_change;
        public ViewHolder(View itemView) {
            super(itemView);
            text_name_tel = itemView.findViewById(R.id.tel_name);
            checkBox_tel = itemView.findViewById(R.id.check_tel);
            text_tel = itemView .findViewById(R.id.text_tel);
            layout_remove = itemView.findViewById(R.id.layout_remove);
            tel_text = itemView.findViewById(R.id.tel_text);
            tel_phone = itemView.findViewById(R.id.tel_text);
            layout_change = itemView.findViewById(R.id.layout_change);
        }
    }
}