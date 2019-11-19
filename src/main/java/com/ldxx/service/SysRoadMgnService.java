package com.ldxx.service;

import java.util.List;

import com.ldxx.bean.SysRoadMgn;

public interface SysRoadMgnService {

	public List<SysRoadMgn> getAllSysRoadMgn();
	
	public int addSysRoadMgn(SysRoadMgn sysRoadMgn);
	
	public int updateSysRoadMgnById(SysRoadMgn sysRoadMgn);
	
	public int delSysRoadMgn(String id);
	
	public int getByIdSysRoadMgn(String id);
}
