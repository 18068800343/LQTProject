package com.ldxx.vo;

import java.math.BigDecimal;

/**
 *
 */
public class PianChaLiangVo {

    //生产计划的到场温度要求
    private BigDecimal arrivetemp;

    //施工偏差的到场温度要求
    public BigDecimal arriveTempOffset;

    //偏差量=来料温度-生产计划的到场温度要求
    public BigDecimal PianCha;

    public BigDecimal getPianCha() {
        return PianCha;
    }

    public void setPianCha(BigDecimal pianCha) {
        PianCha = pianCha;
    }

    public BigDecimal getArrivetemp() {
        return arrivetemp;
    }

    public void setArrivetemp(BigDecimal arrivetemp) {
        this.arrivetemp = arrivetemp;
    }

    public BigDecimal getArriveTempOffset() {
        return arriveTempOffset;
    }

    public void setArriveTempOffset(BigDecimal arriveTempOffset) {
        this.arriveTempOffset = arriveTempOffset;
    }

}
