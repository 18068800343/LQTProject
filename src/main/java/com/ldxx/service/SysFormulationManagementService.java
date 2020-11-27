package com.ldxx.service;

import com.ldxx.bean.SysFormulationManagement;

import java.util.Date;
import java.util.List;

public interface SysFormulationManagementService {

	public int addSysFormulationManagement(SysFormulationManagement sysFormulationManagement);
	
	public int updateSysFormulationManagement(SysFormulationManagement sysFormulationManagement);
	
	public int deleteSysFormulationManagement(String id, String lastUserId, Date date);
	
	public List<SysFormulationManagement> selectAllSysFormulationManagement();
	
	public SysFormulationManagement selectByIdSysFormulationManagement(String id);
	
	public List<SysFormulationManagement> getFlName();
}
