package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.yuzishun.clearservice.Custom.MyScrollView;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.adapter.BannerViewAdapter;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.model.BannerModel;
import com.example.yuzishun.clearservice.model.ServiceinfocationBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.utils.StatusBarUtil;
import com.example.yuzishun.clearservice.utils.TimeUtils;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DetailsActivity extends BaseActivity implements View.OnClickListener, MyScrollView.OnScrollListener {
    @BindView(R.id.layout_can)
    TextView can;
    @BindView(R.id.backer)
    ImageView backer;
    @BindView(R.id.lenge_photo)
    SubsamplingScaleImageView lenge_photo;
    @BindView(R.id.banner)
    ViewPager banner;
    @BindView(R.id.layout_Alpha)
    RelativeLayout layout_Alpha;
    @BindView(R.id.scrollview)
    MyScrollView scrollview;
    @BindView(R.id.service_name)
    TextView service_name;
    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.Orther_money)
    TextView Orther_money;
    @BindView(R.id.kaituan_time)
    TextView kai_time;
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.ll_details_top_dot)
    LinearLayout mLinearLayout;         //底部圆点布局
    private int mSize;                          //圆点数量
    private List<ImageView> mDotView;           //圆点容器
    private String id;
    private List<String> image ;
    private File imageCacheFile;
    private static final int UPTATE_VIEWPAGER = 0;
    private List<BannerModel> list;
    private BannerViewAdapter mAdapter;
    private int autoCurrIndex = 0;//设置当前 第几个图片 被选中
    private HashMap<String,String> hashMap = new HashMap<>();
    @Override
    public int intiLayout() {


        return R.layout.activity_details;

    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        com.jaeger.library.StatusBarUtil.setTranslucentForImageView(this,100,null);

        can.setOnClickListener(this);
        backer.setOnClickListener(this);
        newTel();
        layout_Alpha.getBackground().setAlpha(0);
        scrollview.setScrolListener(this);
    }

    private void newTel() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        hashMap.put("_id",id);
        Observer<ServiceinfocationBean> observer = new Observer<ServiceinfocationBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(final ServiceinfocationBean serviceinfocationBean) {
                Log.e("YZS",serviceinfocationBean.toString());
                if(serviceinfocationBean.getCode()==200){
                service_name.setText(serviceinfocationBean.getData().getService_name()+"");
                money.setText("¥:"+serviceinfocationBean.getData().getService_money()+"");
                Orther_money.setText("¥:"+serviceinfocationBean.getData().getService_original_money()+"");
                Orther_money.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
                    int ping_begin_time = serviceinfocationBean.getData().getPing_begin_time();
                    long ping_end = (int)ping_begin_time;
                    String pin_start = TimeUtils.milliseconds2String(ping_end*1000);
                    kai_time.setText("开团时间:"+pin_start);
                    city.setText(serviceinfocationBean.getData().getService_area_name());
                    //大图设置本地的图片
//                    lenge_photo.setImage(ImageSource.resource(R.mipmap.cop));
//                    接口上面的
                    Glide.with(DetailsActivity.this).load(serviceinfocationBean.getData().getService_content()).downloadOnly(new SimpleTarget<File>() {
                        @Override
                        public void onResourceReady(File resource, GlideAnimation<? super File> glideAnimation) {
                            imageCacheFile = resource;
                            lenge_photo.setImage(ImageSource.uri(resource.getAbsolutePath()));
                        }
                    });
                    lenge_photo.setMinScale(0.1F);

                    lenge_photo.setMaxScale(5.0f);
                    image= new ArrayList<>();
                    image = serviceinfocationBean.getData().getService_banner_img();

                    can.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(DetailsActivity.this, SubmissionActivity.class);
                            intent.putExtra("serviceinfocationBean", serviceinfocationBean);
                            intent.putExtra("_id",serviceinfocationBean.getData().get_id());
                            startActivity(intent);

                        }
                    });




                    list = new ArrayList<>();
                    for (int i = 0; i < image.size(); i++) {
                        BannerModel listBean = new BannerModel();
                        if (i == 0) {
                            listBean.setBannerName("测试");
                            listBean.setBannerUrl(serviceinfocationBean.getData().getService_video_url());
                            listBean.setImage(image.get(i));

                            listBean.setUrlType(1);//图片类型 视频
                            list.add(listBean);
                        }else{
                            listBean.setBannerName("广告");
                            listBean.setBannerUrl(image.get(i));

                            listBean.setUrlType(0);//图片类型 图片
                            list.add(listBean);
                        }
                    }
                    autoBanner();






                }else {
                    Toast.makeText(DetailsActivity.this, serviceinfocationBean.getMsg()+"", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onError(Throwable e) {
                Log.e("YZS",e.getMessage());
//                Toast.makeText(DetailsActivity.this, "请求有误,请看具体原因", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        };
        ApiMethods.getServiceinfo(observer,hashMap);

    }

    private void autoBanner() {
        banner.setOffscreenPageLimit(0);
        mAdapter = new BannerViewAdapter(this,list);
        banner.setAdapter(mAdapter);
            banner.setOnPageChangeListener(new DetailsPhotoPagerListener(DetailsActivity.this,mLinearLayout,list.size()));


    }



    @Override
    public void initData() {

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.backer:
                finish();
                break;
        }

    }


    @Override
    public void onScroll(int scrollY) {
        if(scrollY < 100){
            layout_Alpha.getBackground().setAlpha(0);
//            back.getBackground().setAlpha(255);
//            layout_Alpha.getBackground().setAlpha(255);
        }else if(scrollY >= 100 && scrollY < 860){
            layout_Alpha.getBackground().setAlpha((scrollY-100)/3);
//            back.getBackground().setAlpha(255 - (scrollY-100)/3);
//            roll_view_pager.getBackground().setAlpha(255 - (scrollY-100)/3);
        }else{
            layout_Alpha.getBackground().setAlpha(255);
//            back.getBackground().setAlpha(0);
//            roll_view_pager.getBackground().setAlpha(0);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(imageCacheFile != null){
            imageCacheFile.delete();
        }

    }

    public static int getWindowStateHeight(Context context) {
        int statusBarHeight1 = -1;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {

            statusBarHeight1 = context.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight1;
    }

    public static void setWindowImmersiveState(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = activity.getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

    public class DetailsPhotoPagerListener implements ViewPager.OnPageChangeListener {
        private Context mContext;
        private LinearLayout mLinearLayout;         //底部圆点布局
        private int mSize;                          //圆点数量
        private List<ImageView> mDotView;           //圆点容器

        public DetailsPhotoPagerListener(Context context, LinearLayout linearLayout, int size) {
            mContext = context;
            mLinearLayout = linearLayout;
            mSize = size;
            initData();
        }

        private void initData() {
            mDotView=new ArrayList<>();
            for (int i = 0; i < mSize; i++) {
                ImageView imageView = new ImageView(mContext);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                params.leftMargin = 10;     //设置圆点相距距离
                params.rightMargin = 10;
                if (i == 0) {               //初始化为红点
                    imageView.setBackgroundResource(R.drawable.bg_details_photo_viewindicator_red);
                } else {
                    imageView.setBackgroundResource(R.drawable.bg_details_photo_viewindicator_grey);
                }
                mLinearLayout.addView(imageView,params);
                mDotView.add(imageView);
            }
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < mSize; i++) {
                if ((position % mSize) == i) {      //如果是当前的位置就设置为红点
                    mDotView.get(i).setBackgroundResource(R.drawable.bg_details_photo_viewindicator_red);
                } else {
                    mDotView.get(i).setBackgroundResource(R.drawable.bg_details_photo_viewindicator_grey);
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
