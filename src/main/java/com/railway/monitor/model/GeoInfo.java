package com.railway.monitor.model;

import lombok.Data;

@Data
public class GeoInfo {

    /**
     * errcode : 0
     * address : 北京市朝阳区望京开发街道望京东路4号;利泽东街与屏翠东路路口东189米
     * lon : 116.483642
     * radius : 903
     * lat : 40.008899
     */
    private int errcode;
    private String address;
    private String lon;
    private String radius;
    private String lat;

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public int getErrcode() {
        return errcode;
    }

    public String getAddress() {
        return address;
    }

    public String getLon() {
        return lon;
    }

    public String getRadius() {
        return radius;
    }

    public String getLat() {
        return lat;
    }
}
