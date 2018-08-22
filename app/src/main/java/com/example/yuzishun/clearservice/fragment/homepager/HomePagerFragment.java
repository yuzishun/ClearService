package com.example.yuzishun.clearservice.fragment.homepager;


import android.Manifest;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.Custom.MyViewPager;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.ContentFragment;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.DetailsActivity;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.MessageActivity;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.listActivity;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.searchActivity;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.ContentFragmenthome;
import com.example.yuzishun.clearservice.adapter.GridViewAdapter;
import com.example.yuzishun.clearservice.adapter.GridViewAdapter_home;
import com.example.yuzishun.clearservice.adapter.HP_ReAdapter;
import com.example.yuzishun.clearservice.adapter.ViewPagerAdapter_home;
import com.example.yuzishun.clearservice.adapter.listActivityAdapter;
import com.example.yuzishun.clearservice.base.BaseMvpFragment;
import com.example.yuzishun.clearservice.model.DataBean;
import com.example.yuzishun.clearservice.model.classificationvideoBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.utils.OnEvent;
import com.example.yuzishun.clearservice.utils.indicator.CirclePageIndicator;
import com.example.yuzishun.clearservice.utils.loctionUtils;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePagerFragment extends BaseMvpFragment<HomePagerContact.IHomePagerPresenter> implements HomePagerContact.IHomePagerView, com.example.yuzishun.clearservice.adapter.listActivityAdapter.OnRecyclerViewListener, View.OnClickListener {

    private HomePagerPresenterImpl mainPresenter;
    @BindView(R.id.homepager_tab)
    TabLayout tabLayout;
    @BindView(R.id.viewPager_list)
    MyViewPager viewPager;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.layout_richang)
    RelativeLayout layout_richang;
    @BindView(R.id.layout_clear)
    RelativeLayout layout_clear;
    @BindView(R.id.layout_huli)
    RelativeLayout layout_huli;
    @BindView(R.id.layout_youyan)
    RelativeLayout layout_youyan;
    @BindView(R.id.image_message)
    ImageView image_message;
    @BindView(R.id.layout_loction)
    RelativeLayout layout_loction;
    @BindView(R.id.text_s)
    TextView text_s;
    private TextView begin_id;
    private listActivityAdapter listActivityAdapter;
    private List<String> datas = new ArrayList<String>();//页卡标题集合
    private List<Fragment> fragments;
    private loctionUtils loctionUtils;
    private List<classificationvideoBean.DataBean.ListBean> listBeans = new ArrayList<>();

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home_pager;

    }

    @Override
    protected void setUpView() {
        mainPresenter = new HomePagerPresenterImpl();


    }

    @Override
    protected void setUpData() {
        EventBus.getDefault().register(this);

        loctionUtils = new loctionUtils(getMContext(),text_s);
        initview();
        onclick();
        newTelRecycle();
        //注册EventBus
        dw();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);//反注册EventBus
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();

//        dw();
    }




    @Subscribe
    public void onMessageThread(OnEvent event){
        String msg = event.getMsg();
        text_s.setText(msg);
    }

    private void newTelRecycle() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("action","homepage");
        hashMap.put("page","0");
        hashMap.put("size","3");
        Observer<classificationvideoBean> observer = new Observer<classificationvideoBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(classificationvideoBean classificationvideoBean) {
                if(classificationvideoBean.getCode()==200){
                    listBeans = classificationvideoBean.getData().getList();
                    initRecyclerview();

                }


            }

            @Override
            public void onError(Throwable e) {
                Log.e("YZS",e.getMessage());
                Toast.makeText(getMContext(), "参数错误", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onComplete() {

            }
        };
        ApiMethods.getclassificationvideo(observer,hashMap);




    }

    private void onclick() {
        layout_youyan.setOnClickListener(this);
        layout_huli.setOnClickListener(this);
        layout_clear.setOnClickListener(this);
        layout_richang.setOnClickListener(this);
        image_message.setOnClickListener(this);
        layout_loction.setOnClickListener(this);
    }


    @Override
    protected HomePagerContact.IHomePagerPresenter createPresenter() {
        return new HomePagerPresenterImpl();
    }


    public void initview(){

        datas.add("冰箱清洁");
        datas.add("空调清洗");

        fragments = new ArrayList<>();
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < datas.size(); i++) {
            ContentFragmenthome fragment = ContentFragmenthome.newInstance(datas.get(i));
            fragments.add(fragment);
        }
        for (int i = 0; i < datas.size(); i++) {

            tabLayout.addTab(tabLayout.newTab().setText(datas.get(i)));//添加tab选项

        }
        //fragment的适配器
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
            @Override
            public CharSequence getPageTitle(int position) {
                return datas.get(position);
            }
        };

        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
//        quotation_tab.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
//        datas.clear();


    };
    private void initRecyclerview() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getMContext(),LinearLayoutManager.VERTICAL,false){


            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recyclerview.setLayoutManager(linearLayoutManager);
        listActivityAdapter = new listActivityAdapter(getContext(),listBeans);
        recyclerview.setAdapter(listActivityAdapter);
        listActivityAdapter.setOnRecyclerViewListener(this);




    }

    @Override
    public void onPause() {
        super.onPause();
        datas.clear();

    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(getContext(),DetailsActivity.class));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_richang:

                tiao();

                break;

            case R.id.layout_clear:
                tiao();


                break;
            case R.id.layout_huli:

                tiao();

                break;
            case R.id.layout_youyan:

                tiao();
                break;
            case R.id.image_message:
                startActivity(new Intent(getMContext(), MessageActivity.class));
                break;

            case R.id.layout_loction:
                Intent intent = new Intent(getMContext(),HomeseachActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void dw() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getMContext());
        LayoutInflater inflater = LayoutInflater.from(getMContext());
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
                if (ContextCompat.checkSelfPermission(getMContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        || ActivityCompat.checkSelfPermission(getMContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    //请求权限
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                } else {
                    loctionUtils.loction();

                }


            }else {
                Toast.makeText(getMContext(), "6.0以下不需要开启权限", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(getMContext(), "请开启手机中的GPS定位功能", Toast.LENGTH_SHORT).show();
            dialog.show();
            text_s.setText("定位失败");
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

    public void tiao(){
        startActivity(new Intent(getMContext(), listActivity.class));

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
                } else {
                    // 权限被用户拒绝了。
                    //若是点击了拒绝和不再提醒
                    //关于shouldShowRequestPermissionRationale
                    // 1、当用户第一次被询问是否同意授权的时候，返回false
                    // 2、当之前用户被询问是否授权，点击了false,并且点击了不在询问（第一次询问不会出现“不再询问”的选项），
                    // 之后便会返回false
                    // 3、当用户被关闭了app的权限，该app不允许授权的时候，返回false
                    // 4、当用户上一次不同意授权，没有点击“不再询问”的时候，下一次返回true
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                            || !ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)) {
                        //提示用户前往设置界面自己打开权限
                        Toast.makeText(getMContext(), "请前往设置界面打开对app的定位权限,否则无法定位,", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }
            }
        }
    }



}
