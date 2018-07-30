package com.example.yuzishun.clearservice.present;

import android.os.Bundle;

/**
 * Created by yuzishun on 2018/7/30.
 */
//fragment 的MVp 模式封装
public interface MvpPresenterFragment<V extends MvpViewFragment> {
    void onMvpAttachView(V view, Bundle savedInstanceState);

    void onMvpStart();

    void onMvpResume();

    void onMvpPause();

    void onMvpStop();

    void onMvpSaveInstanceState(Bundle savedInstanceState);

    void onMvpDetachView(boolean retainInstance);

    void onMvpDestroy();
}
