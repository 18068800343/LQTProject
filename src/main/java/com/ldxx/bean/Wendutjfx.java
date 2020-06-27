package com.ldxx.bean;

import java.math.BigDecimal;

public class Wendutjfx {
    private BigDecimal temp;//来料温度
    private String batch;//批次
    private String licenceplate;//车牌
    private BigDecimal zlwendu;//装车温度
    private String stakemark;//桩号
    private String datetime;

    public BigDecimal getTemp() {
        return temp;
    }

    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getLicenceplate() {
        return licenceplate;
    }

    public void setLicenceplate(String licenceplate) {
        this.licenceplate = licenceplate;
    }

    public BigDecimal getZlwendu() {
        return zlwendu;
    }

    public void setZlwendu(BigDecimal zlwendu) {
        this.zlwendu = zlwendu;
    }

    public String getStakemark() {
        return stakemark;
    }

    public void setStakemark(String stakemark) {
        this.stakemark = stakemark;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
