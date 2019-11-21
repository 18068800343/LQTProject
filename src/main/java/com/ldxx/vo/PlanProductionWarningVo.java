package com.ldxx.vo;

import com.ldxx.bean.PlanProductionWarning;

public class PlanProductionWarningVo extends PlanProductionWarning {

    private String planno;

    private String roadname;

    private String roadno;

    private String uname;

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
