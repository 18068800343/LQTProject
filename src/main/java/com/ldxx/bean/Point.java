package com.ldxx.bean;

public class Point {

    double lng;
    double lat;
    String guizeId;

    public Point(double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    public String getGuizeId() {
        return guizeId;
    }

    public void setGuizeId(String guizeId) {
        this.guizeId = guizeId;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
