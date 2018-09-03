package com.example.yuzishun.clearservice.activity.myframnet_Activity;

import android.Manifest;
import android.app.Instrumentation;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.yuzishun.clearservice.Custom.ChoosePhotoDialog;
import com.example.yuzishun.clearservice.Custom.ChoosesexDialog;
import com.example.yuzishun.clearservice.Custom.PermissionHelper;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.base.Content;
import com.example.yuzishun.clearservice.model.QiNiuBean;
import com.example.yuzishun.clearservice.model.UserBean;
import com.example.yuzishun.clearservice.model.UserUpdataBean;
import com.example.yuzishun.clearservice.net.ApiMethods;
import com.example.yuzishun.clearservice.utils.SpUtil;
import com.qiniu.android.common.Zone;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;


import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ThemeConfig;
import cn.finalteam.galleryfinal.model.PhotoInfo;
import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PersonalActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.image_back)
    LinearLayout image_back;
    @BindView(R.id.title_text)
    TextView title_text;
    @BindView(R.id.right_text)
    LinearLayout right_text;
    @BindView(R.id.tel_add)
    TextView tel_add;
    @BindView(R.id.change_icon)
    LinearLayout change_icon;
    @BindView(R.id.change_name)
    LinearLayout change_name;
    @BindView(R.id.change_sex)
    LinearLayout change_sex;
    @BindView(R.id.name_to)
    TextView name_to;
    @BindView(R.id.sex)
    TextView sex;
    @BindView(R.id.icon__)
    CircleImageView icon;
    private String ToKen="";
    private byte[] bytes;
    private String Reconid;
    private PermissionHelper helper;
    private final static int INTENT_CODE_IMAGE_CAPTURE1 = 0;
    private final static int INTENT_CODE_IMAGE_GALLERY1=1;

    @Override
    public int intiLayout() {
        return R.layout.activity_personal2;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_text.setText(R.string.geren_id);
        tel_add.setText(R.string.down_id);
        icon = findViewById(R.id.icon__);
        onclickc();
        newTel();
        QuToKen();
    }

    private void QuToKen() {
        HashMap<String,String> hashMap = new HashMap<>();
        Observer<QiNiuBean> observer = new Observer<QiNiuBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(QiNiuBean qiNiuBean) {
                if(qiNiuBean.getCode()==200){
                    ToKen = qiNiuBean.getData().getToken();
                }else {

                    Toast.makeText(PersonalActivity.this, qiNiuBean.getMsg()+"", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onError(Throwable e) {
                Log.e("YZS",e.getMessage()+"");
            }

            @Override
            public void onComplete() {

            }
        };

        ApiMethods.getQiniu(observer,hashMap);

    }

    private void newTel() {
        HashMap<String,String> hashMap = new HashMap();
        hashMap.put("user_access_token", Content.Token);
//        hashMap.put("_id",User_id);
            Observer<UserBean> observer = new Observer<UserBean>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(UserBean userBean) {
                    Log.e("YZS",userBean.toString());
                    if(userBean.getCode()==200){
                        name_to.setText(userBean.getData().getNickname());
                        sex.setText(userBean.getData().getSex());
                        if(TextUtils.isEmpty(userBean.getData().getHeaderimg_url())){
                            Drawable drawable = getResources().getDrawable(R.mipmap.icon_tx);
                            BitmapDrawable bd = (BitmapDrawable) drawable;
                            Bitmap bmm = bd.getBitmap();
                            bytes = Bitmap2Bytes(bmm);
                        }else {
                            Glide.with(PersonalActivity.this).load(userBean.getData().getHeaderimg_url()).asBitmap().into(new SimpleTarget<Bitmap>() {
                                @Override
                                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                    icon.setImageBitmap(resource);
                                            bytes = Bitmap2Bytes(resource);
                                    Log.e("YZS",bytes.toString());

                                }
                            });



                        }


                        if(userBean.getData().getSex().equals("")){

                            sex.setText("请选择");

                        }



                    }else {

                        Toast.makeText(PersonalActivity.this, userBean.getMsg()+"", Toast.LENGTH_SHORT).show();
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
            ApiMethods.getUser(observer,hashMap);
    }

    private void onclickc() {
        image_back.setOnClickListener(this);
        change_icon.setOnClickListener(this);
        change_name.setOnClickListener(this);
        change_sex.setOnClickListener(this);
        tel_add.setOnClickListener(this);
    }

    @Override
    public void initData() {



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                finish();
                break;
            case R.id.change_icon:

                changtx();

                break;
            case R.id.change_name:
                String name = name_to.getText().toString().trim();
                Intent intent = new Intent(this, changnameActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
                break;
            case R.id.change_sex:

                changersex();
                break;
            case R.id.tel_add:

                //上传配置
                Configuration config = new Configuration.Builder()
                        .chunkSize(256 * 1024)  //分片上传时，每片的大小。 默认 256K
                        .putThreshhold(512 * 1024)  // 启用分片上传阀值。默认 512K
                        .connectTimeout(10) // 链接超时。默认 10秒
                        .responseTimeout(60) // 服务器响应超时。默认 60秒
                        .zone(Zone.zone0) // 设置区域，指默认 Zone.zone0 注：这步是最关键的
                        .build();


                try {


//                String data = String.valueOf(uri);
                String key = "images/"+Reconid+"1.jpg";
                String token = ToKen.toString().trim();
                UploadManager uploadManager = new UploadManager(config);
                                Log.e("YZS",ToKen.toString());
                                Log.e("YZS",bytes.toString());
                                Log.e("YZS",key+"");
                uploadManager.put(bytes, key, token,
                        new UpCompletionHandler() {
                            @Override
                            public void complete(String key, ResponseInfo info, JSONObject response) {
                                if(info.isOK()) {

                                    Log.e("YZS", "Upload Success");
                                } else {
                                    Log.e("YZS", "Upload Fail");
                                    Log.e("YZS",info.toString()+"");
                                }
                            }
                        }, null);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("user_access_token", Content.Token);
                hashMap.put("headerimg_url", Content.domain+key);
                hashMap.put("sex", sex.getText().toString().trim());
                hashMap.put("nickname", name_to.getText().toString().trim());

                Observer<UserUpdataBean> observer = new Observer<UserUpdataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserUpdataBean userUpdataBean) {
                        Log.e("YZS", userUpdataBean.toString());
                        if (userUpdataBean.getCode() == 200) {

                            Toast.makeText(PersonalActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                            finish();

                        } else {
                            Toast.makeText(PersonalActivity.this, userUpdataBean.getMsg() + "", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("YZS", e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                };
                ApiMethods.getUserUpdata(observer, hashMap);
                Log.e("YZS",hashMap.toString());

                break;

                }catch (Exception e){

                }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void changersex() {
        ChoosesexDialog choosePhotoDialog = new ChoosesexDialog(this) {
            @Override
            protected void openphoto() {
                sex.setText(R.string.man_id);
            }

            @Override
            protected void openCream() {
                sex.setText(R.string.icon_woman);

            }
        };
        choosePhotoDialog.show();

    }


    private void changtx() {
        ChoosePhotoDialog choosePhotoDialog = new ChoosePhotoDialog(this) {
            @Override
            protected void openphoto() {
                Intent intentToPickPic = new Intent(Intent.ACTION_PICK, null);
                // 如果限制上传到服务器的图片类型时可以直接写如："image/jpeg 、 image/png等的类型" 所有类型则写 "image/*"
                intentToPickPic.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/jpeg");
                startActivityForResult(intentToPickPic, INTENT_CODE_IMAGE_GALLERY1);



            }

            @Override
            protected void openCream() {
                Intent pIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//调用摄像头action
                startActivityForResult(pIntent, INTENT_CODE_IMAGE_CAPTURE1);//requestcode


//                final Intent i = new Intent(Intent.ACTION_GET_CONTENT, null);
//                //判断是不是6。0以上的手机
//                if(Build.VERSION.SDK_INT >= 23){
//
//
//                    //判断是否获取了权限
//                    if(PermissionHelper.hasPermissions(getContext(),Manifest.permission.CAMERA)){
//
//                        i.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
//                        startActivityForResult(i, INTENT_CODE_IMAGE_GALLERY1);
//                    }else {
//                        //没有获取权限的话，主动去申请权限
//                        helper = new PermissionHelper(PersonalActivity.this);
//                        helper.requestPermissions("需要访问你的你的相机，请允许", new PermissionHelper.PermissionListener() {
//                            @Override
//                            public void doAfterGrand(String... permission) {
//                                //获取之后的操作
//                                i.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
//                                startActivityForResult(i, INTENT_CODE_IMAGE_GALLERY1);
//                            }
//
//                            @Override
//                            public void doAfterDenied(String... permission) {
//                                //没获取的操作
//
//                            }
//                        },Manifest.permission.CAMERA);
//
//                    }
//
//
//                }else {
//
//                    i.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
//                    startActivityForResult(i, INTENT_CODE_IMAGE_GALLERY1);
//                }

            }
        };
        choosePhotoDialog.show();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case INTENT_CODE_IMAGE_CAPTURE1:
                if (resultCode == RESULT_OK) {
                    Bundle pBundle = data.getExtras(); //从intent对象中获取数据，
                    if (pBundle != null) {
                        Bitmap pBitmap = (Bitmap) pBundle.get("data");
                        if (pBitmap != null) {
                            Reconid = getPicNameFromPath(data.getData().getPath());
                            icon.setImageBitmap(pBitmap);
                            bytes = Bitmap2Bytes(pBitmap);
                        }
                    }
                }
                break;

            case INTENT_CODE_IMAGE_GALLERY1:
//                Log.d(TAG, "onActivityResult:相册 " + data.getData().toString());
                ContentResolver resolver = getContentResolver();

                try {
                    if(data==null){
                        icon.setBackgroundResource(R.mipmap.icon_tx);

                    }else {

                    if(data.getData()==null){
                        icon.setBackgroundResource(R.mipmap.icon_tx);

                    }else {
//                        uri = data.getData();
                        Reconid = getPicNameFromPath(data.getData().getPath());
                        InputStream inputStream = resolver.openInputStream(data.getData());

                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                        icon.setImageBitmap(bitmap);
                        bytes = Bitmap2Bytes(bitmap);
                    }
                    }
                } catch (FileNotFoundException e) {


                    e.printStackTrace();
                }

                //                Cursor query = resolver.query(data.getData(), null, null, null, null);
//
//                String str = null;
//                while (query.moveToNext()) {
//                    Log.d(TAG, "onActivityResult:数量 " + query.getCount());
//                    str =query.getString(query.getColumnIndex(MediaStore.Images.Media.DATA));
//                    Log.d(TAG, "onActivityResult: 列名" + query.getString(query.getColumnIndex(MediaStore.Images.Media.DATA)));
//                }
//                query.close();
//                Picasso.with(this).load(new File(str)).centerCrop().resize(OtherUtils.dip2px(this,100),OtherUtils.dip2px(this,100))
//                        .error(R.mipmap.pictures_no).into(mIvDispaly);
                break;
        }

    }

    /**
     * 把Bitmap转Byte
     * @Author HEH
     * @EditTime 2010-07-19 上午11:45:56
     */
    public static byte[] Bitmap2Bytes(Bitmap bm){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }
    public static String getPicNameFromPath(String picturePath){
        String temp[] = picturePath.replaceAll("\\\\","/").split("/");
        String fileName = "";
        if(temp.length > 1){
            fileName = temp[temp.length - 1];
        }
        return fileName;
    }



}
