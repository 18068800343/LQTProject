package com.ldxx.dao;

import java.util.List;

import com.ldxx.bean.SysFormulationManagement;
import com.ldxx.bean.SysMaterialAttached;

public interface SysFormulationManagementDao {

	public int addSysFormulationManagement(SysFormulationManagement sysFormulationManagement);
	
	public int updateSysFormulationManagement(SysFormulationManagement sysFormulationManagement);
	
	public int deleteSysFormulationManagement(String id);
	
	public List<SysFormulationManagement> selectAllSysFormulationManagement();
	
	public SysFormulationManagement selectByIdSysFormulationManagement();
	
	public List<SysFormulationManagement> getFlName();
	
	public int addFuShuCaiLiao(List<SysMaterialAttached> list);
	
	public List<SysMaterialAttached> selectAllFuShuCaiLiao();
	
}
