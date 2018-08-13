package com.example.yuzishun.clearservice.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.media.PlaybackParams;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private List<String> list;
    private String url="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
    public HP_ReAdapter(Context mContext, List<String> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public HP_ReAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.homepager_recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final HP_ReAdapter.ViewHolder holder, int position) {
        holder.Originalprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        holder.text_money.setText(list.get(position));
        holder.layout_xx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                mContext.startActivities(new Intent[]{new Intent(mContext, DetailsActivity.class)});
            }
        });

        holder.videoView.setUp(url
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "饺子闭眼睛");
        holder.videoView.thumbImageView.setImageResource(R.mipmap.ceshitwo);



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
        TextView Originalprice,text_money;
        private LinearLayout layout_xx;
        public ViewHolder(View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.vide_view_home);
            Originalprice = itemView.findViewById(R.id.Originalprice);
            text_money = itemView.findViewById(R.id.text_money);
            layout_xx = itemView.findViewById(R.id.layout_xx);

        }
    }

}
