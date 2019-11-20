package com.ldxx.vo;

import com.ldxx.bean.ProductDispatch;

import java.math.BigDecimal;

public class ProductDispatchVo extends ProductDispatch {

    private String uName;

    private String flName;

    private String roadNo;

    private String roadName;

    private String batch;

    //报废重量
    public BigDecimal pitchWeight;

    //单价
    private BigDecimal price;

    private String feiliaoId;

    public String getFeiliaoId() {
        return feiliaoId;
    }

    public void setFeiliaoId(String feiliaoId) {
        this.feiliaoId = feiliaoId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getFlName() {
        return flName;
    }

    public void setFlName(String flName) {
        this.flName = flName;
    }

    public String getRoadNo() {
        return roadNo;
    }

    public void setRoadNo(String roadNo) {
        this.roadNo = roadNo;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public BigDecimal getPitchWeight() {
        return pitchWeight;
    }

    public void setPitchWeight(BigDecimal pitchWeight) {
        this.pitchWeight = pitchWeight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
