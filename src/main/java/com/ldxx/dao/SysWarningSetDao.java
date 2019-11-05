package com.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.SysWarningSet;

public interface SysWarningSetDao {
	
	int addSysWarningSet(@Param("ss")SysWarningSet ss);
	
	int updateSysWarningSetById(@Param("ss") SysWarningSet ss);
	
	List<SysWarningSet> getAllSysWarningSet();
	
	int delSysWarningSet(@Param("id") String id);

}
