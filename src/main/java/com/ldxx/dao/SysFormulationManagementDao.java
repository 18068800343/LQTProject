package com.ldxx.dao;

import com.ldxx.bean.SysFormulationManagement;
import com.ldxx.bean.SysMaterialAttached;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SysFormulationManagementDao {

	public int addSysFormulationManagement(@Param("sysFormulationManagement")SysFormulationManagement sysFormulationManagement);
	
	public int updateSysFormulationManagement(@Param("sysFormulationManagement")SysFormulationManagement sysFormulationManagement);
	
	public int deleteSysFormulationManagement(String id, String lastUserId, Date date);
	
	public List<SysFormulationManagement> selectAllSysFormulationManagement();
	
	public SysFormulationManagement selectByIdSysFormulationManagement(String id);
	
	public List<SysFormulationManagement> getFlName();
	
	public int addFuShuCaiLiao(List<SysMaterialAttached> list);
	
	public List<SysMaterialAttached> selectAllFuShuCaiLiao();
	
	public int deleteByIdFuShuCaiLiao(String id);
	
	public List<SysMaterialAttached> selectByIdFuShuCaiLiao(String id);
	
}
