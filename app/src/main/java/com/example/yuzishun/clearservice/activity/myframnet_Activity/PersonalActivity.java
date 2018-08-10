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
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.Custom.ChoosePhotoDialog;
import com.example.yuzishun.clearservice.Custom.ChoosesexDialog;
import com.example.yuzishun.clearservice.Custom.CircleImageView;
import com.example.yuzishun.clearservice.Custom.PermissionHelper;
import com.example.yuzishun.clearservice.R;
import com.example.yuzishun.clearservice.base.BaseActivity;
import com.example.yuzishun.clearservice.utils.SpUtil;


import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ThemeConfig;
import cn.finalteam.galleryfinal.model.PhotoInfo;

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

    }

    private void onclickc() {
        image_back.setOnClickListener(this);
        change_icon.setOnClickListener(this);
        change_name.setOnClickListener(this);
        change_sex.setOnClickListener(this);
    }

    @Override
    public void initData() {


        //设置名字
        SpUtil spUtil = new SpUtil(PersonalActivity.this, "dat1");
        String name = spUtil.getString("name", "null");
        name_to.setText(name);
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
                            icon.setImageBitmap(pBitmap);
                        }
                    }
                }
                break;

            case INTENT_CODE_IMAGE_GALLERY1:
//                Log.d(TAG, "onActivityResult:相册 " + data.getData().toString());
                ContentResolver resolver = getContentResolver();

                try {
                    if(data.getData()==null){
                        icon.setBackgroundResource(R.mipmap.icon_tx);

                    }else {
                        InputStream inputStream = resolver.openInputStream(data.getData());

                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);


                        icon.setImageBitmap(bitmap);
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


}
