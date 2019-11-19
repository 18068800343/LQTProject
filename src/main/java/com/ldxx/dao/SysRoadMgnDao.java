package com.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.SysRoadMgn;
import com.ldxx.bean.SysWarningSet;

public interface SysRoadMgnDao {
	
	public int addSysRoadMgn(@Param("sysRoadMgn")SysRoadMgn sysRoadMgn);
	
	public int updateSysRoadMgnById(@Param("sysRoadMgn")SysRoadMgn sysRoadMgn);
	
	public List<SysRoadMgn> getAllSysRoadMgn();
	
	public int delSysRoadMgn(@Param("id") String id);
	
	public int getByIdSysRoadMgn(@Param("id") String id);
}
