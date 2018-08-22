package com.example.yuzishun.clearservice.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.model.BannerModel;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by yuzishun on 2018/8/16.
 */

public class BannerViewAdapter extends PagerAdapter {

    private Context context;
    private List<BannerModel> listBean;
    private String url="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";

    public BannerViewAdapter(Activity context, List<BannerModel> list) {
        this.context = context.getApplicationContext();
        if (list == null || list.size() == 0) {
            this.listBean = new ArrayList<>();
        } else {
            this.listBean = list;
        }
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {

            View view= LayoutInflater.from(context).inflate(R.layout.layout_item_vp,null);
            ImageView imageView = view.findViewById(R.id.imageview);
            final VideoView videoview = view.findViewById(R.id.videoview);
            final ImageView videoviewimage = view.findViewById(R.id.videoimag);
            final ImageView start = view.findViewById(R.id.start);
            //在这里可以做相应的操作
            //数据填充
            if(listBean.get(position).getUrlType() == 0){
                videoview.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                videoviewimage.setVisibility(View.GONE);
                Glide.with(context).load(listBean.get(position).getBannerUrl())
                        .skipMemoryCache(true)
                        .into(imageView);
                start.setVisibility(View.GONE);
            }else {
                Glide.with(context).load(listBean.get(position).getImage())
                        .into(videoviewimage);
                imageView.setVisibility(View.GONE);
                videoviewimage.setVisibility(View.VISIBLE);
                start.setVisibility(View.VISIBLE);
                videoviewimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        start.setVisibility(View.GONE);
                        videoviewimage.setVisibility(View.GONE);
                        videoview.setVisibility(View.VISIBLE);
                        videoview.setVideoPath(url);
                        videoview.start();
                        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                start.setVisibility(View.VISIBLE);
                                videoviewimage.setVisibility(View.VISIBLE);
                                videoview.setVisibility(View.GONE);

                            }
                        });

                    }
                });
//                videoview.setUp(url,JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,listBean.get(position).getBannerName());
//                Glide.with(context).load(listBean.get(position).getImage()).into(videoview.thumbImageView);

            }
        container.addView(view);
        return view;
        }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return listBean.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (View) object;
    }
}