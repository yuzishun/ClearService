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
//        holder.videoView.setVisibility(View.GONE);
//        holder.iv_first_frame.setVisibility(View.VISIBLE);
//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.FILL_PARENT,
//                RelativeLayout.LayoutParams.FILL_PARENT);
//        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//        holder.videoView.setLayoutParams(layoutParams);
//        holder.videoView.setVideoPath(url);
//        holder.videoView.setScaleY(PlaybackParams.AUDIO_FALLBACK_MODE_FAIL);
//        holder.videoView.setScaleX(PlaybackParams.AUDIO_FALLBACK_MODE_FAIL);

//        holder..setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.setOnInfoListener(new MediaPlayer.OnInfoListener() {
//                    @Override
//                    public boolean onInfo(MediaPlayer mp, int what, int extra) {
//                        if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
//                            videoView.setBackgroundColor(Color.TRANSPARENT);
//                        return true;
//                    }
//                });




        holder.videoView.setUp(url
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "饺子闭眼睛");
        holder.videoView.thumbImageView.setImageResource(R.mipmap.ceshitwo);

//        Glide.with(mContext)
//                .load(holder.videoView.thumbImageView)
//                .into(R.mipmap.cehsi);
//        holder.videoView.thumbImageView.setI("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");


//        holder.videoView.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(IMediaPlayer iMediaPlayer) {
//                //                //播放结束后的动作
//                holder.statr.setVisibility(View.VISIBLE);
//                holder.videoView.setVisibility(View.GONE);
//                holder.iv_first_frame.setVisibility(View.VISIBLE);
//
//            }
//        });

        //获取第一桢
//        holder.iv_first_frame.setVisibility(View.VISIBLE);
////        String path  = Environment.getExternalStorageDirectory().getPath();
//        MediaMetadataRetriever media = new MediaMetadataRetriever();
//        media.setDataSource(url,new HashMap<String, String>());
//        Bitmap bitmap = media.getFrameAtTime();
//        holder.iv_first_frame.setImageBitmap(bitmap);


//        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
//
//        mmr.setDataSource(mContext.getApplicationContext(),Uri.parse(url));
//
//        Bitmap bitmap = mmr.getFrameAtTime();//获取第一帧图片
//        holder.iv_first_frame.setImageBitmap(bitmap);
//        mmr.release();//释放资源

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
