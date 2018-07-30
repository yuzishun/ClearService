package com.example.yuzishun.clearservice.present;

/**
 * Created by yuzishun on 2018/7/30.
 */

import android.os.Bundle;

/**
 * 抽象为接口
 *
 */
public interface MvpPresenter<V extends MvpView>{
    void onMvpAttachView(V view, Bundle savedInstanceState);

    void onMvpStart();

    void onMvpResume();

    void onMvpPause();

    void onMvpStop();

    void onMvpSaveInstanceState(Bundle savedInstanceState);

    void onMvpDetachView(boolean retainInstance);

    void onMvpDestroy();
}
