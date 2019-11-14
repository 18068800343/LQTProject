package com.ldxx.vo;

import com.ldxx.bean.BatchMgt;

public class BatchMgtVo extends BatchMgt {

	private String roadname;

	private String roadno;
	
	private String flname;
	
	private String yuguweight;

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

	public String getFlname() {
		return flname;
	}

	public void setFlname(String flname) {
		this.flname = flname;
	}

	public String getYuguweight() {
		return yuguweight;
	}

	public void setYuguweight(String yuguweight) {
		this.yuguweight = yuguweight;
	}

}