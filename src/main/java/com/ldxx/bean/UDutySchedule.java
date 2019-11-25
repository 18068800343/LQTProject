package com.ldxx.bean;
/**
 * 值班管理
 * @author hp
 *
 */
public class UDutySchedule {

	public String id;

	private String userId;//user_id
	private String workId;//工号
	private String uName;//姓名
	
	private String datetimeStart;//开始日期时间

	private String datetimeEnd;//结束日期时间

	private String remarks;//备注

	private int deleteState;//删除状态0：删除。1：存在

	private String editUserId;

	private String editDatetime;
	
	private String userName;
	
	public String getId() {
		return id;
	}

	
	public String getWorkId() {
		return workId;
	}


	public void setWorkId(String workId) {
		this.workId = workId;
	}


	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDatetimeStart() {
		return datetimeStart;
	}

	public void setDatetimeStart(String datetimeStart) {
		this.datetimeStart = datetimeStart;
	}

	public String getDatetimeEnd() {
		return datetimeEnd;
	}

	public void setDatetimeEnd(String datetimeEnd) {
		this.datetimeEnd = datetimeEnd;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getDeleteState() {
		return deleteState;
	}

	public void setDeleteState(int deleteState) {
		this.deleteState = deleteState;
	}

	public String getEditUserId() {
		return editUserId;
	}

	public void setEditUserId(String editUserId) {
		this.editUserId = editUserId;
	}

	public String getEditDatetime() {
		return editDatetime;
	}

	public void setEditDatetime(String editDatetime) {
		this.editDatetime = editDatetime;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	

}
