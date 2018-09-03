package com.example.yuzishun.clearservice.utils;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.searchActivity;
import com.example.yuzishun.clearservice.adapter.listActivityAdapter;
import com.example.yuzishun.clearservice.adapter.telfjAdapter;
import com.example.yuzishun.clearservice.model.LocationInfo;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yuzishun on 2018/8/21.
 */

public class loctionUtils{

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new MyAMapLocationListener();
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;
    private Context context;
    private TextView textView;
    private telfjAdapter telfjAdapter;
    private List<LocationInfo> mList;
    private RecyclerView recyclerView;
    private LinearLayout layout_fj;
    private int i;
    private String qu;
    private TextView city;
    private Activity activity;
    private double latitude,longitude;
    private RecyclerView telfuwu_recyclerView;
    public loctionUtils(Context context, TextView textView, RecyclerView recyclerView, LinearLayout layout_fj,int i,TextView city,Activity Activity) {
        this.context = context;
        this.textView = textView;
        this.recyclerView = recyclerView;
        this.layout_fj = layout_fj;
        this.i = i;
        this.city = city;
        this.activity = Activity;
    }


    public loctionUtils(Context context, TextView textView) {
        this.context = context;
        this.textView = textView;
    }

    public void loction() {
//初始化定位
        mLocationClient = new AMapLocationClient(context);
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //获取一次定位结果：
        //该方法默认为false。
        mLocationOption.setOnceLocation(false);

        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocationLatest(false);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔
//        mLocationOption.setInterval()
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(true);
        //关闭缓存机制
        mLocationOption.setLocationCacheEnable(false);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();

        mList = new ArrayList<>();



    }
    public void initRecy(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false){


            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        if(i==0){

            recyclerView.setLayoutManager(new LinearLayoutManager(context));

        }else {
            recyclerView.setLayoutManager(linearLayoutManager);

        }



        telfjAdapter = new telfjAdapter(context,mList);
        recyclerView.setAdapter(telfjAdapter);
        telfjAdapter.setOnRecyclerViewListener(new listActivityAdapter.OnRecyclerViewListener() {
            @Override
            public void onItemClick(int position) {

                Intent intent = new Intent();
                intent.putExtra("city",city.getText().toString().trim());
                intent.putExtra("loction_text",textView.getText().toString().trim());
                intent.putExtra("loction_jw",longitude+","+latitude);
                EventBus.getDefault().post(
                        new OnEvent(city.getText().toString().trim()+""));
                activity.setResult(50,intent);
                activity.finish();


            }
        });
    }

    public void inittelRe(){


    }


    public class MyAMapLocationListener implements AMapLocationListener, PoiSearch.OnPoiSearchListener {

        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                    textView.setText(aMapLocation.getAddress());
//                    qu = aMapLocation.getCity()+""+aMapLocation.getAdCode();
                    Log.e("YZS", aMapLocation.getAddress());
                    city.setText(aMapLocation.getCity());
                    Toast.makeText(context, "定位成功", Toast.LENGTH_SHORT).show();
                    EventBus.getDefault().post(
                            new OnEvent(aMapLocation.getAddress()+""));
                    //定位成功回调信息，设置相关消息
                    aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                    latitude = aMapLocation.getLatitude();//获取纬度
                    longitude = aMapLocation.getLongitude();//获取经度
                    aMapLocation.getAccuracy();//获取精度信息
                    Log.d("haha", aMapLocation.getAddress());
                    LocationInfo locationInfo = new LocationInfo();
                    locationInfo.setAddress(aMapLocation.getAddress());
                    locationInfo.setLatitude(latitude);
                    locationInfo.setLonTitude(longitude);
                    mList.clear();
                    mList.add(locationInfo);
                    telfjAdapter.notifyDataSetChanged();
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date(aMapLocation.getTime());
                    df.format(date);//定位时间
                    PoiSearch.Query query = new PoiSearch.Query("", "生活服务", "");
                    query.setPageSize(20);
                    PoiSearch search = new PoiSearch(context, query);
                    search.setBound(new PoiSearch.SearchBound(new LatLonPoint(latitude, longitude), 10000));
                    search.setOnPoiSearchListener(this);
                    search.searchPOIAsyn();
                    layout_fj.setVisibility(View.VISIBLE);
                } else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    Log.e("YZS", "location Error, ErrCode:"
                            + aMapLocation.getErrorCode() + ", errInfo:"
                            + aMapLocation.getErrorInfo());
                    city.setText("定位失败");
                    if (aMapLocation.getErrorCode() == 12) {
                        Toast.makeText(context, "app没有定位权限", Toast.LENGTH_SHORT).show();
                        layout_fj.setVisibility(View.GONE);

                    }
                }

            }

        }

        @Override
        public void onPoiSearched(PoiResult result, int i) {
            PoiSearch.Query query = result.getQuery();
            ArrayList<PoiItem> pois = result.getPois();
            for (PoiItem poi : pois) {
                String name = poi.getCityName();
                String snippet = poi.getSnippet();
                LocationInfo info = new LocationInfo();
                info.setAddress(snippet);
                LatLonPoint point = poi.getLatLonPoint();

                info.setLatitude(point.getLatitude());
                info.setLonTitude(point.getLongitude());
                mList.add(info);
                Log.d("haha", "poi" + snippet);
            }
            telfjAdapter.notifyDataSetChanged();
        }

        @Override
        public void onPoiItemSearched(PoiItem poiItem, int i) {

        }
    }


    public void Destory() {
        mLocationClient = new AMapLocationClient(context);

        mLocationClient.onDestroy();
    }

    /**
     * 判断手机的定位服务是否开启
     *
     * @param
     * @return true 表示开启
     */
    public boolean isLocationEnabled() {
        int locationMode = 0;
        String locationProviders;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                locationMode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            return locationMode != Settings.Secure.LOCATION_MODE_OFF;
        } else {
            locationProviders = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            return !TextUtils.isEmpty(locationProviders);
        }
    }


    /**
     * 强制帮用户打开GPS
     *
     * @param context
     */
    public static final void openGPS(Context context) {
        Intent GPSIntent = new Intent();
        GPSIntent.setClassName("com.android.settings",
                "com.android.settings.widget.SettingsAppWidgetProvider");
        GPSIntent.addCategory("android.intent.category.ALTERNATIVE");
        GPSIntent.setData(Uri.parse("custom:3"));
        try {
            PendingIntent.getBroadcast(context, 0, GPSIntent, 0).send();
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }



    /**
     * 判断是否需要获取权限，6.0一下不需要获取权限
     *
     * @return
     */
    public boolean showCheckPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return true;
        } else {
            return false;
        }
    }




}
