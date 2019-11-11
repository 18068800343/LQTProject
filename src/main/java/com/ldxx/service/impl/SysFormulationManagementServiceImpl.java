package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.SysFormulationManagement;
import com.ldxx.dao.SysFormulationManagementDao;
import com.ldxx.service.SysFormulationManagementService;

@Service
@Transactional
public class SysFormulationManagementServiceImpl implements SysFormulationManagementService{

	@Autowired
	private SysFormulationManagementDao sdao;
	@Override
	public int addSysFormulationManagement(SysFormulationManagement sysFormulationManagement) {
		int num = sdao.addSysFormulationManagement(sysFormulationManagement);
		return num;
	}

	@Override
	public int updateSysFormulationManagement(SysFormulationManagement sysFormulationManagement) {
		int num = sdao.updateSysFormulationManagement(sysFormulationManagement);
		return num;
	}

	@Override
	public int deleteSysFormulationManagement(String id) {
		int num = sdao.deleteSysFormulationManagement(id);
		return num;
	}

	@Override
	public List<SysFormulationManagement> selectAllSysFormulationManagement() {
		List<SysFormulationManagement> slist = sdao.selectAllSysFormulationManagement();
		return slist;
	}

	@Override
	public SysFormulationManagement selectByIdSysFormulationManagement() {
		SysFormulationManagement s =sdao.selectByIdSysFormulationManagement();
		return s;
	}

	@Override
	public List<SysFormulationManagement> getFlName() {
		return sdao.getFlName();
	}

}
