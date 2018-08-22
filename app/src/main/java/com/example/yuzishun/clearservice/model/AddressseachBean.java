package com.example.yuzishun.clearservice.model;

import java.io.Serializable;

/**
 * Created by yuzishun on 2018/8/21.
 */

public class AddressseachBean implements Serializable {
    private double longitude;//经度
    private double latitude;//纬度
    private String title;//信息标题
    private String text;//信息内容
    private String address;

    public AddressseachBean(double longitude, double latitude, String title, String text, String address) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.title = title;
        this.text = text;
        this.address = address;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getAddress() {
        return address;
    }
}