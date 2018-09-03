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
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.yuzishun.clearservice.Custom.MyViewPager;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.ContentFragment;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.DetailsActivity;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.MessageActivity;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.listActivity;
import com.example.yuzishun.clearservice.activity.mainfragment_activity.searchActivity;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.ChooseCrdeActivity;
import com.example.yuzishun.clearservice.activity.myframnet_Activity.ContentFragmenthome;
import com.example.yuzishun.clearservice.adapter.GridViewAdapter;
import com.example.yuzishun.clearservice.adapter.GridViewAdapter_home;
import com.example.yuzishun.clearservice.adapter.HP_ReAdapter;
import com.example.yuzishun.clearservice.adapter.ViewPagerAdapter_home;
import com.example.yuzishun.clearservice.adapter.listActivityAdapter;
import com.example.yuzishun.clearservice.base.BaseMvpFragment;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.DataBean;
import com.example.yuzishun.clearservice.model.HomepagerRecommend;
import com.example.yuzishun.clearservice.model.classificationBean;
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
    @BindView(R.id.layout_chaduo)
    RelativeLayout layout_chaduo;
    @BindView(R.id.look_low)
    Button look_low;
    @BindView(R.id.layout_emty_one)
    LinearLayout layout_emty_one;
    @BindView(R.id.layout_tablayout)
    LinearLayout layout_tablayout;
    @BindView(R.id.layout_viewpager)
    LinearLayout layout_viewpager;
    @BindView(R.id.text_s)
    TextView text_s;
    @BindView(R.id.button_pin)
    Button button_pin;
    @BindView(R.id.layout_tiao)
    LinearLayout layout_tiao;
    private String idone,idtwo,idthree,idfour;
    @BindView(R.id.iamge_one_home) ImageView imageone;@BindView(R.id.iamge_two_home) ImageView image_two;@BindView(R.id.iamge_three_home) ImageView image_three;@BindView(R.id.iamge_four_home) ImageView image_four;
    @BindView(R.id.text_renmenone)TextView text_renmenone;@BindView(R.id.text_renmentwo)TextView text_renmentwo;@BindView(R.id.text_renmenthree)TextView text_renmenthree;@BindView(R.id.text_renmenfour)TextView text_renmenfour;
    private TextView begin_id;
    private listActivityAdapter listActivityAdapter;
    private List<HomepagerRecommend.DataBean> datas = new ArrayList<>();//页卡标题集合
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
        button_pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //选择卡片
                startActivity(new Intent(getMContext(), ChooseCrdeActivity.class));

            }
        });
        look_low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //更多列表
                Toast.makeText(getContext(), "暂时没有更多", Toast.LENGTH_SHORT).show();


            }
        });
        newTel();
        recommend();
    }

    private void recommend() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("user_access_token", Content.Token);

        Observer<HomepagerRecommend> observer = new Observer<HomepagerRecommend>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HomepagerRecommend homepagerRecommend) {

                if (homepagerRecommend.getCode() == 200) {


                        datas = homepagerRecommend.getData();
                        initview();
                    for (int i = 0; i <homepagerRecommend.getData().size() ; i++) {

                        if(homepagerRecommend.getData().get(i).getServiceList().size()==0){
                            layout_tiao.setVisibility(View.GONE);

                        }

                    }

                } else {
                    Toast.makeText(getMContext(), homepagerRecommend.getMsg() + "", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {
            Log.e("YZS",e.getMessage());
                initview();
                for (int i = 0; i <datas.size() ; i++) {

                    if(datas.get(i).getServiceList().size()==0){
                        layout_tiao.setVisibility(View.GONE);
                    }

                }
            }

            @Override
            public void onComplete() {

            }
        };
        ApiMethods.getHomePageReco(observer,hashMap);
        Log.e("YZS",hashMap.toString());

    }

    private void newTel() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("page","0");
        hashMap.put("size","4");
        hashMap.put("classify_branch_id","");
        hashMap.put("classify_type","1");

        //网络请求
        Observer<classificationBean> observer = new Observer<classificationBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(classificationBean classificationBean) {
                Log.e("YZS",classificationBean.getData().getList().size()+"");
                if(classificationBean.getCode()==200){

                    if(classificationBean.getData()!=null){
                        try {


                        for (int i = 0; i < classificationBean.getData().getList().size(); i++) {
                            if(classificationBean.getData().getList().size()==1){
                                idone = classificationBean.getData().getList().get(0).get_id();
                                text_renmenone.setText(classificationBean.getData().getList().get(0).getClassify_name());

//                                Glide.with(getContext()).load(R.mipmap.familtwork).into(imageone);

                                Glide.with(getContext()).load(classificationBean.getData().getList().get(0).getClassify_logo()).into(imageone);


                            }else if(classificationBean.getData().getList().size()==2){
                                idone = classificationBean.getData().getList().get(0).get_id();
                                text_renmenone.setText(classificationBean.getData().getList().get(0).getClassify_name());
//                                Glide.with(getContext()).load(R.mipmap.familtwork).into(imageone);
                                Glide.with(getContext()).load(classificationBean.getData().getList().get(0).getClassify_logo()).into(imageone);
                                idtwo = classificationBean.getData().getList().get(1).get_id();
                                text_renmentwo.setText(classificationBean.getData().getList().get(1).getClassify_name());

//                                Glide.with(getContext()).load(R.mipmap.clear).into(image_two);
                                Glide.with(getContext()).load(classificationBean.getData().getList().get(1).getClassify_logo()).into(image_two);


                            }else if(classificationBean.getData().getList().size()==3){
                                idone = classificationBean.getData().getList().get(0).get_id();
                                text_renmenone.setText(classificationBean.getData().getList().get(0).getClassify_name());
//                                Glide.with(getContext()).load(R.mipmap.familtwork).into(imageone);
                                Glide.with(getContext()).load(classificationBean.getData().getList().get(0).getClassify_logo()).into(imageone);
                                idtwo = classificationBean.getData().getList().get(1).get_id();
                                text_renmentwo.setText(classificationBean.getData().getList().get(1).getClassify_name());
//                                Glide.with(getContext()).load(R.mipmap.clear).into(image_two);
                                Glide.with(getContext()).load(classificationBean.getData().getList().get(1).getClassify_logo()).into(image_two);
                                idthree = classificationBean.getData().getList().get(2).get_id();
                                text_renmenfour.setText(classificationBean.getData().getList().get(2).getClassify_name());

//                                Glide.with(getContext()).load(R.mipmap.jiaju).into(image_three);
                                Glide.with(getContext()).load(classificationBean.getData().getList().get(2).getClassify_logo()).into(image_three);

                            }else {
                                idone = classificationBean.getData().getList().get(0).get_id();
                                text_renmenone.setText(classificationBean.getData().getList().get(0).getClassify_name());
//                                Glide.with(getContext()).load(R.mipmap.familtwork).into(imageone);
                                Glide.with(getContext()).load(classificationBean.getData().getList().get(0).getClassify_logo()).into(imageone);
                                idtwo = classificationBean.getData().getList().get(1).get_id();
                                text_renmentwo.setText(classificationBean.getData().getList().get(1).getClassify_name());
//                                Glide.with(getContext()).load(R.mipmap.clear).into(image_two);
                                Glide.with(getContext()).load(classificationBean.getData().getList().get(1).getClassify_logo()).into(image_two);
                                idthree = classificationBean.getData().getList().get(2).get_id();
                                text_renmenfour.setText(classificationBean.getData().getList().get(2).getClassify_name());
//                                Glide.with(getContext()).load(R.mipmap.jiaju).into(image_three);

                                Glide.with(getContext()).load(classificationBean.getData().getList().get(2).getClassify_logo()).into(image_three);
                                idfour = classificationBean.getData().getList().get(3).get_id();

                                text_renmenthree.setText(classificationBean.getData().getList().get(3).getClassify_name());

//                                Glide.with(getContext()).load(R.mipmap.clearcar).into(image_four);

                                Glide.with(getContext()).load(classificationBean.getData().getList().get(3).getClassify_logo()).into(image_four);

                            }
                        }

                        }catch (Exception e){

                        }
                    }
                }else {

                    Toast.makeText(getContext(), classificationBean.getMsg()+"", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onError(Throwable e) {
                Log.e("YZS",e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        ApiMethods.getclassifiction(observer,hashMap);


    }

    @Override
    protected void setUpData() {
        //注册EventBus
        EventBus.getDefault().register(this);

        loctionUtils = new loctionUtils(getMContext(),text_s);
        onclick();
        newTelRecycle();

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
        recommend();
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

                }else {
                    Toast.makeText(getContext(), classificationvideoBean.getMsg()+"", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onError(Throwable e) {
                Log.e("YZS",e.getMessage());

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


        if(datas.size()==0){
            layout_chaduo.setVisibility(View.GONE);
            layout_emty_one.setVisibility(View.VISIBLE);
            layout_tablayout.setVisibility(View.GONE);
            layout_viewpager.setVisibility(View.GONE);
        }else {
            fragments = new ArrayList<>();
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            for (int i = 0; i < datas.size(); i++) {
                ContentFragmenthome fragment = ContentFragmenthome.newInstance();
                fragments.add(fragment);
            }
            for (int i = 0; i < datas.size(); i++) {

                tabLayout.addTab(tabLayout.newTab().setText(datas.get(i).getClassify_name()));//添加tab选项

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
                    return datas.get(position).getClassify_name();
                }
            };

            viewPager.setAdapter(mAdapter);
            tabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
//        quotation_tab.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
//        datas.clear();
        }

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
//        startActivity(new Intent(getContext(),DetailsActivity.class));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_richang:

                Intent intent = new Intent(getMContext(), listActivity.class);
                intent.putExtra("textname",text_renmenone.getText().toString().trim());
                intent.putExtra("_id",idone);
                startActivity(intent);


                break;

            case R.id.layout_clear:
                Intent intent1 = new Intent(getMContext(), listActivity.class);
                intent1.putExtra("textname",text_renmentwo.getText().toString().trim());
                intent1.putExtra("_id",idtwo);

                startActivity(intent1);


                break;
            case R.id.layout_huli:

                Intent intent2 = new Intent(getMContext(), listActivity.class);
                intent2.putExtra("textname",text_renmenthree.getText().toString().trim());
                intent2.putExtra("_id",idthree);

                startActivity(intent2);

                break;
            case R.id.layout_youyan:

                Intent intent3 = new Intent(getMContext(), listActivity.class);
                intent3.putExtra("textname",text_renmenfour.getText().toString().trim());
                intent3.putExtra("_id",idfour);

                startActivity(intent3);
                break;
            case R.id.image_message:
                startActivity(new Intent(getMContext(), MessageActivity.class));
                break;

            case R.id.layout_loction:
                Intent intent4 = new Intent(getMContext(),HomeseachActivity.class);
                startActivity(intent4);
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
                if (ContextCompat.checkSelfPermission(getMContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        || ActivityCompat.checkSelfPermission(getMContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    //请求权限
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                } else {
                    loctionUtils.loction();

                }
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
