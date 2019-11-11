package com.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.SysRoadMgn;
import com.ldxx.bean.SysWarningSet;

public interface SysRoadMgnDao {
	
	int addSysRoadMgn(SysRoadMgn sysRoadMgn);
	
	int updateSysRoadMgnById(SysRoadMgn sysRoadMgn);
	
	List<SysRoadMgn> getAllSysRoadMgn();
	
	int delSysRoadMgn(@Param("id") String id);

}
