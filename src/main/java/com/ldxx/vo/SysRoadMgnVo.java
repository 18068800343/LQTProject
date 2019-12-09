package com.ldxx.vo;

import com.ldxx.bean.SysRoadMgn;

import java.math.BigDecimal;

public class SysRoadMgnVo extends SysRoadMgn {
    private BigDecimal allXuQiu;
    private BigDecimal allGongYing;

    public BigDecimal getAllXuQiu() {
        return allXuQiu;
    }

    public void setAllXuQiu(BigDecimal allXuQiu) {
        this.allXuQiu = allXuQiu;
    }

    public BigDecimal getAllGongYing() {
        return allGongYing;
    }

    public void setAllGongYing(BigDecimal allGongYing) {
        this.allGongYing = allGongYing;
    }
}
