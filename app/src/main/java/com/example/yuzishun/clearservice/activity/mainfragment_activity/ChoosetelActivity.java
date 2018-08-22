package com.example.yuzishun.clearservice.activity.mainfragment_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.adapter.listActivityAdapter;
import com.example.yuzishun.clearservice.adapter.telAdapterbeyond;
import com.example.yuzishun.clearservice.adapter.telAdapternobeyond;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.addressBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.utils.SpUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ChoosetelActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.right_text)
    LinearLayout right_text;
    @BindView(R.id.tel_add)
    TextView tel_add;
    @BindView(R.id.nobeyondRV)
    RecyclerView nobeyondRV;
    @BindView(R.id.beyondRV)
    RecyclerView beyondRV;
    private telAdapterbeyond telAdapterbeyond;
    private telAdapternobeyond telAdapternobeyond;
    private List<String> list = new ArrayList<String>();
    private String id;
    private List<addressBean.DataBean.ListBean> listYse = new ArrayList();
    private List<addressBean.DataBean.ListBean> listNo = new ArrayList();
    @Override
    public int intiLayout() {
        return R.layout.activity_choosetel;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_text.setText("选择服务地址");
        tel_add.setText(R.string.newtel_add);

        onclick();
        newTel();

    }

    private void newTel() {
        Intent intent = getIntent();
        id =intent.getStringExtra("_id");
        SpUtil spUtil1 = new SpUtil(getApplicationContext(),"Userid");
        String userid = spUtil1.getString("User_id","null");
        Log.e("YZS", userid+"///"+id+"");
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("user_access_token",Content.Token);
        hashMap.put("page","0");
        hashMap.put("size","100");
        hashMap.put("service_filter_id",id);
        Observer<addressBean> observer = new Observer<addressBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(final addressBean addressBean) {
                if(addressBean.getCode()==200){
                    Log.e("YZS",addressBean.getData().getList().size()+"总长度");
                    for (int i = 0; i <addressBean.getData().getList().size() ; i++) {

                        if(addressBean.getData().getList().get(i).getIs_filter()==1){
                            listYse.add(addressBean.getData().getList().get(i));

                        }else {

                            listNo.add(addressBean.getData().getList().get(i));

                        }
                    }


//                    Log.e("YZS",listYse.toString()+""+listNo.toString());

                    if(listYse.size()==0){


                    }else {
                        telAdapterbeyond = new telAdapterbeyond(ChoosetelActivity.this,listYse,1);

                        nobeyondRV.setLayoutManager(new LinearLayoutManager(ChoosetelActivity.this));
                        nobeyondRV.setAdapter(telAdapterbeyond);
                    }
                    if(listNo.size()==0){

                    }else {
                        telAdapternobeyond = new telAdapternobeyond(ChoosetelActivity.this,listNo);
                        beyondRV.setLayoutManager(new LinearLayoutManager(ChoosetelActivity.this));
                        beyondRV.setAdapter(telAdapternobeyond);
                    }

                    telAdapterbeyond.setOnRecyclerViewListener(new listActivityAdapter.OnRecyclerViewListener() {
                        @Override
                        public void onItemClick(int position) {
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("addressBean",addressBean);
                            bundle.putInt("position",position);
                            Intent intent=new Intent();
                            intent.putExtra("bundle",bundle);

                            setResult(22,intent);
                            finish();

                        }
                    });



                }

            }

            @Override
            public void onError(Throwable e) {
                Log.e("YZS",e.getMessage());
                Toast.makeText(ChoosetelActivity.this, "请求失败,请看具体信息", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onComplete() {

            }
        };
        ApiMethods.getaddress(observer,hashMap);
        Log.e("YZS",hashMap.toString());

    }

    private void onclick() {
        image_back.setOnClickListener(this);
        right_text.setOnClickListener(this);
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
            case R.id.right_text:

                startActivity(new Intent(this,AddtelActivity.class));

                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(listYse.size()==0){




        }else {
            listYse.clear();
            listNo.clear();
            newTel();
        }



    }


}
