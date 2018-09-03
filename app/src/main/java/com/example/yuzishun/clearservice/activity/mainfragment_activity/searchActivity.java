package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.example.yuzishun.clearservice.Custom.ClearEditText;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.adapter.SeachAddressAdapter;
import com.example.yuzishun.clearservice.adapter.listActivityAdapter;
import com.example.yuzishun.clearservice.adapter.telfjAdapter;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.base.MyApplication;
import com.example.yuzishun.clearservice.model.AddressseachBean;
import com.example.yuzishun.clearservice.model.LocationInfo;
import com.example.yuzishun.clearservice.utils.loctionUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class searchActivity extends BaseActivity implements View.OnClickListener, PoiSearch.OnPoiSearchListener {
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.loction_text)
    TextView loction_text;
    private loctionUtils  loctionUtils;
    @BindView(R.id.text_repeat)
    TextView text_repeat;
    private TextView begin_id;
    @BindView(R.id.telfujin_recyclerView)
    RecyclerView telfujin_recyclerView;
    @BindView(R.id.layout_fj)
    LinearLayout layout_fj;
    @BindView(R.id.layout_dq)
    LinearLayout layout_dq;
    @BindView(R.id.seach_edit)
    ClearEditText seach_edit;
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.lv_address)
    ListView lv_address;
    private PoiSearch.Query query;
    private int page=0;
    private PoiSearch poiSearch;
    private SeachAddressAdapter adapter;
    private ArrayList<AddressseachBean> data = new ArrayList<AddressseachBean>();
    @Override
    public int intiLayout() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_text.setText(R.string.search_tel);
        image_back.setOnClickListener(this);

        loctionUtils= new loctionUtils(this,loction_text,telfujin_recyclerView,layout_fj,0,city,searchActivity.this);
        text_repeat.setOnClickListener(this);
        Log.e("YZS",loctionUtils.isLocationEnabled()+"");
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        adapter = new SeachAddressAdapter(this,data);
        lv_address.setAdapter(adapter);

        setOnclick();

    }

    private void setOnclick() {
        seach_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!"".equals(s.toString())){
                    layout_dq.setVisibility(View.GONE);
                    layout_fj.setVisibility(View.GONE);
                    lv_address.setVisibility(View.VISIBLE);
                    lv_address.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Intent intent = new Intent();

                            intent.putExtra("city",city.getText().toString().trim());
                            intent.putExtra("loction_text",data.get(position).getText());
                            intent.putExtra("loction_jw",data.get(position).getLongitude()+","+data.get(position).getLatitude());

                            setResult(50,intent);
//
                            finish();

                        }
                    });
                    String str=seach_edit.getText().toString();
                    if(str.length()>0){
                        seach(str);

                    }
                }else {
                    layout_dq.setVisibility(View.VISIBLE);
                    layout_fj.setVisibility(View.VISIBLE);
                    lv_address.setVisibility(View.GONE);

                }

            }


            @Override
            public void afterTextChanged(Editable s) {
//                String str=seach_edit.getText().toString();
//                if (str.length()>0){
////                    layout_dq.setVisibility(View.GONE);
////                    layout_fj.setVisibility(View.GONE);
////                    layout_seac.setVisibility(View.VISIBLE);
//                    seach(str);
//                }else {
//
//                }
            }
        });
        lv_address.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent();//ListView item点击回调
//                intent.putExtra("data",data.get(i));
//                setResult(100,intent);
//                finish();
            }
        });


    }


    private void dw() {
        AlertDialog.Builder builder = new AlertDialog.Builder(searchActivity.this);
        LayoutInflater inflater = LayoutInflater.from(searchActivity.this);
        View v = inflater.inflate(R.layout.layout_dialog_tel, null);
        TextView seach_id = v.findViewById(R.id.seach_id);
        begin_id = v.findViewById(R.id.begin_id);

         final Dialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setContentView(v);
        dialog.getWindow().setGravity(Gravity.CENTER);
        if(loctionUtils.isLocationEnabled()==true){

            dialog.dismiss();
            if(loctionUtils.showCheckPermissions()){
                //获取权限（如果没有开启权限，会弹出对话框，询问是否开启权限）
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    //请求权限
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                } else {
                    loctionUtils.loction();
                    loctionUtils.initRecy();

                }


            }else {
                Toast.makeText(this, "6.0以下不需要开启权限", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this, "请开启手机中的GPS定位功能", Toast.LENGTH_SHORT).show();
            dialog.show();
            begin_id.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivityForResult(intent, 1315);
                    dialog.dismiss();

                }
            });

        }
    }




    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_back:

                finish();
                break;
            case R.id.text_repeat:
                loctionUtils.loction();
                loctionUtils.initRecy();

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loctionUtils.Destory();


    }

    @Override
    protected void onResume() {
        super.onResume();
        dw();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    // 权限被用户同意。
                    // 执形我们想要的操作
                    loctionUtils.loction();
                    loctionUtils.initRecy();

                } else {
                    // 权限被用户拒绝了。
                    //若是点击了拒绝和不再提醒
                    //关于shouldShowRequestPermissionRationale
                    // 1、当用户第一次被询问是否同意授权的时候，返回false
                    // 2、当之前用户被询问是否授权，点击了false,并且点击了不在询问（第一次询问不会出现“不再询问”的选项），
                    // 之后便会返回false
                    // 3、当用户被关闭了app的权限，该app不允许授权的时候，返回false
                    // 4、当用户上一次不同意授权，没有点击“不再询问”的时候，下一次返回true
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                            || !ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                        //提示用户前往设置界面自己打开权限
                        Toast.makeText(this, "请前往设置界面打开对app的定位权限,否则无法定位,", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }
            }
        }
    }

    private void seach(String address){
        //keyWord表示搜索字符串，
        //第二个参数表示POI搜索类型，二者选填其一，选用POI搜索类型时建议填写类型代码，码表可以参考下方（而非文字）
        //cityCode表示POI搜索区域，可以是城市编码也可以是城市名称，也可以传空字符串，空字符串代表全国在全国范围内进行搜索
        query=new PoiSearch.Query(address,"", city.getText().toString().trim()+"");
        query.setPageSize(300);// 设置每页最多返回多少条poiitem
        query.setPageNum(page);//设置查询页码

        poiSearch = new PoiSearch(this, query);
        poiSearch.searchPOIAsyn();//调用 PoiSearch 的 searchPOIAsyn() 方法发送请求。

        poiSearch.setOnPoiSearchListener(this);

        //周边检索
        //   poiSearch.setBound(new SearchBound(new LatLonPoint(locationMarker.getPosition().latitude,
        //          locationMarker.getPosition().longitude), 1000));//设置周边搜索的中心点以及半径
    }



    @Override
    public void onPoiSearched(PoiResult poiResult, int i) {
        data.clear();
        //解析result获取POI信息
        if(i == 1000 && poiResult != null) {
            ArrayList<PoiItem> items = poiResult.getPois();
            for (PoiItem item : items) {
                //获取经纬度对象
                LatLonPoint llp = item.getLatLonPoint();
                double lon = llp.getLongitude();
                double lat = llp.getLatitude();

                //获取标题
                String title = item.getTitle();
                //获取内容
                String text = item.getSnippet();
                String name=item.getAdName();
                String cityName=item.getCityName();
                String area=item.getBusinessArea();
                String  provinceName=item.getProvinceName();

                String addressInfo=provinceName+cityName+name+text;

                data.add(new AddressseachBean(lon, lat, title, text,addressInfo));
            }
            adapter.refreshData(data);
        }

    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }
}
