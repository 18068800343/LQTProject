package com.ldxx.vo;

import java.math.BigDecimal;

/**
 * 成本进度
 */
public class ChenBenJinDuVo {

    private BigDecimal pdNeed;//每日成品需要量(日供料计划)

    private BigDecimal chenneng;//日实际产能

    private BigDecimal feiliao;//每日废料

    private BigDecimal feiliaobi;//废料比

    private String datetime;//日期

    public BigDecimal getPdNeed() {
        return pdNeed;
    }

    public void setPdNeed(BigDecimal pdNeed) {
        this.pdNeed = pdNeed;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public BigDecimal getChenneng() {
        return chenneng;
    }

    public void setChenneng(BigDecimal chenneng) {
        this.chenneng = chenneng;
    }

    public BigDecimal getFeiliao() {
        return feiliao;
    }

    public void setFeiliao(BigDecimal feiliao) {
        this.feiliao = feiliao;
    }

    public BigDecimal getFeiliaobi() {
        return feiliaobi;
    }

    public void setFeiliaobi(BigDecimal feiliaobi) {
        this.feiliaobi = feiliaobi;
    }
}
