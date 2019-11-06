package com.ldxx.dao;

import java.util.List;

import com.ldxx.bean.SysFormulationManagement;

public interface SysFormulationManagementDao {

	public int addSysFormulationManagement(SysFormulationManagement sysFormulationManagement);
	
	public int updateSysFormulationManagement(SysFormulationManagement sysFormulationManagement);
	
	public int deleteSysFormulationManagement(String id);
	
	public List<SysFormulationManagement> selectAllSysFormulationManagement();
	
	public SysFormulationManagement selectByIdSysFormulationManagement();
	
	
}
