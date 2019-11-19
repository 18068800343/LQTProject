package com.ldxx.bean;

import java.math.BigDecimal;

/**
 * 废料管理
 */
public class WhWasteMgn {

    public String id;

    //编号
    public String wasteNo;

    //生产计划id
    public String planId;

    //批次id
    public String batchId;

    //报废重量
    public BigDecimal pitchWeight;

    //报废类型
    public String pitchType;

    //报废单价
    public BigDecimal unitPrice;

    //报废原因
    public String reason;

    //0未操作1完全废弃2调度走;3取消状态
    public int warningState;

    //报废用户id
    public String dealUserId;

    //报废时间
    public String dealTime;

    //逻辑删除
    public int deleteState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWasteNo() {
        return wasteNo;
    }

    public void setWasteNo(String wasteNo) {
        this.wasteNo = wasteNo;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public BigDecimal getPitchWeight() {
        return pitchWeight;
    }

    public void setPitchWeight(BigDecimal pitchWeight) {
        this.pitchWeight = pitchWeight;
    }

    public String getPitchType() {
        return pitchType;
    }

    public void setPitchType(String pitchType) {
        this.pitchType = pitchType;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getWarningState() {
        return warningState;
    }

    public void setWarningState(int warningState) {
        this.warningState = warningState;
    }

    public String getDealUserId() {
        return dealUserId;
    }

    public void setDealUserId(String dealUserId) {
        this.dealUserId = dealUserId;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public int getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(int deleteState) {
        this.deleteState = deleteState;
    }
}
