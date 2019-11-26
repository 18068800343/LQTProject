package com.ldxx.vo;

import com.ldxx.bean.PlanProductionWarning;

import java.math.BigDecimal;

public class PlanProductionWarningVo extends PlanProductionWarning {

    private String planno;

    private String recipeid;

    private String roadname;

    private String roadno;

    private String uname;

    private BigDecimal pitchweight;

    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPitchweight() {
        return pitchweight;
    }

    public void setPitchweight(BigDecimal pitchweight) {
        this.pitchweight = pitchweight;
    }

    public String getRecipeid() {
        return recipeid;
    }

    public void setRecipeid(String recipeid) {
        this.recipeid = recipeid;
    }

    public String getRoadno() {
        return roadno;
    }

    public void setRoadno(String roadno) {
        this.roadno = roadno;
    }

    public String getPlanno() {
        return planno;
    }

    public void setPlanno(String planno) {
        this.planno = planno;
    }

    public String getRoadname() {
        return roadname;
    }

    public void setRoadname(String roadname) {
        this.roadname = roadname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
