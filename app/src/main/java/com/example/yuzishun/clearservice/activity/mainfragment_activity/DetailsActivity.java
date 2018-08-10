package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.layout_can)
    TextView can;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.lenge_photo)
    SubsamplingScaleImageView lenge_photo;
    @BindView(R.id.roll_view_pager)
    RollPagerView roll_view_pager;
    @BindView(R.id.layout_Alpha)
    RelativeLayout layout_Alpha;
    @Override
    public int intiLayout() {


        return R.layout.activity_details;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        can.setOnClickListener(this);
        back.setOnClickListener(this);
//        lenged();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.cop);
        lenge_photo.setImage(ImageSource.resource(R.mipmap.cop));
        lenge_photo.setMinScale(0.1F);
        lenge_photo.setMaxScale(5.0f);
        layout_Alpha.getBackground().setAlpha(50);

    }


    @Override
    public void initData() {
        rollview();
    }

    private void rollview() {
        //设置播放时间间隔
        roll_view_pager.setPlayDelay(2000);
        //设置透明度
        roll_view_pager.setAnimationDurtion(500);
        //设置适配器
        roll_view_pager.setAdapter(new TestNormalAdapter(roll_view_pager));
        //自定义指示器图片
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        //设置圆点指示器颜色
        roll_view_pager.setHintView(new ColorPointHintView(this, Color.YELLOW,Color.WHITE));
        //设置文字指示器
//       mRollViewPager.setHintView(new TextHintView(this));
        //隐藏指示器
//        roll_view_pager.setHintView(null);
        roll_view_pager.pause();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_can:
                startActivity(new Intent(this, SubmissionActivity.class));

                break;
            case R.id.back:
                finish();
                break;
        }

    }


    private class TestNormalAdapter extends LoopPagerAdapter {
        private int[] imgs = { //轮播的图片
                R.mipmap.cehsi,
                R.mipmap.icon_woman_false,
                R.mipmap.icon_woman,

        };

        public TestNormalAdapter(RollPagerView viewPager) {
            super(viewPager);
        }


        @Override
        public View getView(ViewGroup container, final int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { //点击事件   具体点击了哪一张图片的下标
//                    Toast.makeText(DetailsActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                }
            });

            return view;
        }

        @Override
        protected int getRealCount() {
            return imgs.length;
        }


    }
}
