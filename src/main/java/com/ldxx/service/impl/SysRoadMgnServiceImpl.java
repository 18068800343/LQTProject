package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.SysRoadMgn;
import com.ldxx.dao.SysRoadMgnDao;
import com.ldxx.service.SysRoadMgnService;
import com.ldxx.util.LDXXUtils;

@Service
@Transactional
public class SysRoadMgnServiceImpl implements SysRoadMgnService{

	@Autowired
	SysRoadMgnDao srmDao;
	@Override
	public List<SysRoadMgn> getAllSysRoadMgn() {
		List<SysRoadMgn> list = srmDao.getAllSysRoadMgn();
		return list;
	}

	@Override
	public int addSysRoadMgn(SysRoadMgn sysRoadMgn) {
		int status=0;
		sysRoadMgn.setRoadId(LDXXUtils.getUUID12());
		status = srmDao.addSysRoadMgn(sysRoadMgn);
		return status;
	}

	@Override
	public int updateSysRoadMgnById(SysRoadMgn sysRoadMgn) {
		int status=0;
		status =srmDao.updateSysRoadMgnById(sysRoadMgn);
		return status;
	}

	@Override
	public int delSysRoadMgn(String id) {
		int status=0;
		status=srmDao.delSysRoadMgn(id);
		return status;
	}

	@Override
	public int getByIdSysRoadMgn(String id) {
		int status=srmDao.getByIdSysRoadMgn(id);
		return status;
	}

}
