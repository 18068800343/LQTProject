package com.ldxx.bean;


public class GuizeYujing {
    String carId;
    String lng;
    String lat;
    String vehicleStatus;
    String plate;
    String distance;
    String gpsTime;
    String guizeId;

    public GuizeYujing(String carId, String lng, String lat, String vehicleStatus, String plate, String distance, String gpsTime, String guizeId) {
        this.carId = carId;
        this.lng = lng;
        this.lat = lat;
        this.vehicleStatus = vehicleStatus;
        this.plate = plate;
        this.distance = distance;
        this.gpsTime = gpsTime;
        this.guizeId = guizeId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(String gpsTime) {
        this.gpsTime = gpsTime;
    }

    public String getGuizeId() {
        return guizeId;
    }

    public void setGuizeId(String guizeId) {
        this.guizeId = guizeId;
    }
}
