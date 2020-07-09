package com.ldxx.vo;

import com.ldxx.bean.SiteCompactionSpeed;

import java.math.BigDecimal;

public class SiteCompactionSpeedVo extends SiteCompactionSpeed {
    private String roadname;
    private String roadno;
    private String roadid;
    private String uname;
    private String batch;
    private String sitenumber;
    private String stakeMark;
    private String name1;
    private BigDecimal name1speed;
    private String name2;
    private BigDecimal name2speed;

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public BigDecimal getName1speed() {
        return name1speed;
    }

    public void setName1speed(BigDecimal name1speed) {
        this.name1speed = name1speed;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public BigDecimal getName2speed() {
        return name2speed;
    }

    public void setName2speed(BigDecimal name2speed) {
        this.name2speed = name2speed;
    }

    public String getStakeMark() {
        return stakeMark;
    }

    public void setStakeMark(String stakeMark) {
        this.stakeMark = stakeMark;
    }

    public String getSitenumber() {
        return sitenumber;
    }

    public void setSitenumber(String sitenumber) {
        this.sitenumber = sitenumber;
    }

    public String getRoadname() {
        return roadname;
    }

    public void setRoadname(String roadname) {
        this.roadname = roadname;
    }

    public String getRoadno() {
        return roadno;
    }

    public void setRoadno(String roadno) {
        this.roadno = roadno;
    }

    public String getRoadid() {
        return roadid;
    }

    public void setRoadid(String roadid) {
        this.roadid = roadid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
