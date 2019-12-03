package com.ldxx.service;

import com.ldxx.bean.SysRoadMgn;

import java.util.List;

public interface SysRoadMgnService {

	public List<SysRoadMgn> getAllSysRoadMgn(String luduanquanxian);
	
	public int addSysRoadMgn(SysRoadMgn sysRoadMgn);
	
	public int updateSysRoadMgnById(SysRoadMgn sysRoadMgn);
	
	public int delSysRoadMgn(String id);
	
	public SysRoadMgn getByIdSysRoadMgn(String id);

	public int finishRoad(String id);
}
