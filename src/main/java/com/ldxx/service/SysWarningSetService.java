package com.ldxx.service;

import java.util.List;
import com.ldxx.bean.SysWarningSet;

public interface SysWarningSetService {
	
	int addSysWarningSet(SysWarningSet ss);
	
	int updateSysWarningSetById(SysWarningSet ss);
	
	List<SysWarningSet> getAllSysWarningSet();
	
	int delSysWarningSet(String id);

}
