package com.ldxx.bean;

import java.math.BigDecimal;

public class SysRoadMgnLowcase {
    private String roadid;

    private String roadno;

    private String roadname;

    private BigDecimal startlng;

    private BigDecimal startlat;

    private BigDecimal endlng;

    private BigDecimal endlat;

    private String remarks;

    private int deletestate;

	public String getRoadid() {
		return roadid;
	}

	public void setRoadid(String roadid) {
		this.roadid = roadid;
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

	public BigDecimal getStartlng() {
		return startlng;
	}

	public void setStartlng(BigDecimal startlng) {
		this.startlng = startlng;
	}

	public BigDecimal getStartlat() {
		return startlat;
	}

	public void setStartlat(BigDecimal startlat) {
		this.startlat = startlat;
	}

	public BigDecimal getEndlng() {
		return endlng;
	}

	public void setEndlng(BigDecimal endlng) {
		this.endlng = endlng;
	}

	public BigDecimal getEndlat() {
		return endlat;
	}

	public void setEndlat(BigDecimal endlat) {
		this.endlat = endlat;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getDeletestate() {
		return deletestate;
	}

	public void setDeletestate(int deletestate) {
		this.deletestate = deletestate;
	}
}
