package com.ldxx.service;

import java.util.List;

import com.ldxx.bean.SysFormulationManagement;

public interface SysFormulationManagementService {

	public int addSysFormulationManagement(SysFormulationManagement sysFormulationManagement);
	
	public int updateSysFormulationManagement(SysFormulationManagement sysFormulationManagement);
	
	public int deleteSysFormulationManagement(String id);
	
	public List<SysFormulationManagement> selectAllSysFormulationManagement();
	
	public SysFormulationManagement selectByIdSysFormulationManagement();
	
	public List<SysFormulationManagement> getFlName();
}
