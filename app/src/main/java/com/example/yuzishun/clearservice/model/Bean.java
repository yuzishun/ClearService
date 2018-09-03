package com.example.yuzishun.clearservice.model;

/**
 * Created by yuzishun on 2018/8/27.
 */

public class Bean {
    private boolean isChecked;


    public Bean(){

    }
    public Bean(boolean isCheched) {
        this.isChecked = isCheched;
    }
    public boolean isChecked() {
        return isChecked;
    }
    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

}
