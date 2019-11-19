package com.ldxx.vo;

import com.ldxx.bean.SiteIncomingMaterialTempWarning;

public class SiteIncomingMaterialTempWarningVo extends SiteIncomingMaterialTempWarning {

    private String flname;

    private String roadno;

    private String roadname;

    private String batch;

    private String batchId;

    private String uname;

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
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

    public String getFlname() {
        return flname;
    }

    public void setFlname(String flname) {
        this.flname = flname;
    }

    public String getRoadno() {
        return roadno;
    }

    public void setRoadno(String roadno) {
        this.roadno = roadno;
    }

    public String getRoadname() {
        return roadname;
    }

    public void setRoadname(String roadname) {
        this.roadname = roadname;
    }
}
