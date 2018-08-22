package com.example.yuzishun.clearservice.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.media.PlaybackParams;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.widget.IjkVideoView;
import com.example.yuzishun.clearservice.BuildConfig;
import com.example.yuzishun.clearservice.MainActivity;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.AddtelActivity;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.DetailsActivity;
import com.example.yuzishun.clearservice.model.classificationvideoBean;
import com.example.yuzishun.clearservice.utils.CountDownUtils;
import com.example.yuzishun.clearservice.utils.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by yuzishun on 2018/8/6.
 */

public class HP_ReAdapter extends RecyclerView.Adapter<HP_ReAdapter.ViewHolder> {
    private Context mContext;
    private List<classificationvideoBean.DataBean.ListBean> list;
    public HP_ReAdapter(Context mContext, List<classificationvideoBean.DataBean.ListBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public HP_ReAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.homepager_recyclerview_item, parent, false));
    }
    public void setData(List<classificationvideoBean.DataBean.ListBean> newPeopleList){
        this.list = newPeopleList;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(final HP_ReAdapter.ViewHolder holder, final int position) {
        holder.Originalprice.setText("原价¥:"+list.get(position).getService_original_money());
        holder.Originalprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        holder.text_money.setText("¥:"+list.get(position).getService_money());
        int ping_number = list.get(position).getPing_number();
        int have_ping_number = list.get(position).getHave_ping_number();
        int numnber = ping_number - have_ping_number;
        holder.tuan.setText("已经参加人员"+have_ping_number+"人，还差"+numnber+"人拼成");
        //将服务器返回的时间戳 转换为long 类型，转换为时间格式的
        int ping_end_time = list.get(position).getPing_end_time();
        long ping_end = (int)ping_end_time;
        long current = System.currentTimeMillis()/1000;
        if(ping_end<current){
            holder.time_.setText("已结束");
            holder.pin_button.setText("不可拼团");
            holder.shengyu.setVisibility(View.GONE);

        }else {
            new CountDownUtils(ping_end - current,holder.time_).startCount();
        }

        String pin_end = TimeUtils.milliseconds2String(ping_end*1000);





        holder.layout_xx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DetailsActivity.class);
                intent.putExtra("id",list.get(position).get_id());
                mContext.startActivity(intent);

            }
        });
        holder.name.setText(list.get(position).getService_name());
        holder.videoView.setUp(list.get(position).getService_video_url()
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "饺子闭眼睛");
        Glide.with(mContext).load(list.get(position).getService_banner_img().get(0)).into(holder.videoView.thumbImageView);





    }
    public void PauseStopVideo(){
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        JZVideoPlayerStandard videoView;
        private Button pin_button;
        TextView Originalprice,text_money,name,tuan,time_,shengyu;

        private LinearLayout layout_xx;
        public ViewHolder(View itemView) {
            super(itemView);
            tuan = itemView.findViewById(R.id.tuan);
            name = itemView.findViewById(R.id.name);
            pin_button = itemView.findViewById(R.id.pin_button);
            time_ = itemView.findViewById(R.id.time_);
            shengyu = itemView.findViewById(R.id.shengyu);
            videoView = itemView.findViewById(R.id.vide_view_home);
            Originalprice = itemView.findViewById(R.id.Originalprice);
            text_money = itemView.findViewById(R.id.text_money);
            layout_xx = itemView.findViewById(R.id.layout_xx);

        }
    }


}
