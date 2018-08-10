package com.example.yuzishun.clearservice.Custom;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzishun.clearservice.R;

import java.util.List;


/**
 * Created by yuzishun on 2018/8/3.
 */

public abstract class ChoosePhotoDialog extends Dialog implements View.OnClickListener {

    private TextView cancelButton;
    private TextView mPhoto;
    private TextView mCamera;

    private OnChoosePhotoListener mOnChoosePhotoListener;


    public ChoosePhotoDialog(Context context) {
        super(context, R.style.TransparentFrameWindowStyle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_choose_photo);
        mPhoto = (TextView) findViewById(R.id.button_photo);
        mCamera = (TextView) findViewById(R.id.button_camera);
        cancelButton = (TextView) findViewById(R.id.button_cancel);
        mPhoto.setOnClickListener(this);
        mCamera.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
        init();
    }

    private void init() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        window.setAttributes(params);
        window.setGravity(Gravity.BOTTOM);
        setCanceledOnTouchOutside(true);

    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        switch (i) {
            case R.id.button_camera:
                openCream();

                dismiss();
                break;
            case R.id.button_photo:
                openphoto();
                //自定义方法的单选
                dismiss();
                break;
            case R.id.button_cancel:
                dismiss();
                break;
        }

    }

    protected abstract void openphoto();


    public interface OnChoosePhotoListener {

    }
    protected abstract void openCream();

}

