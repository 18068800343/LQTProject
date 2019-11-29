package com.ldxx.service.impl;

import com.ldxx.bean.SysRoadMgn;
import com.ldxx.dao.SysRoadMgnDao;
import com.ldxx.service.SysRoadMgnService;
import com.ldxx.util.LDXXUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysRoadMgnServiceImpl implements SysRoadMgnService{

	@Autowired
	SysRoadMgnDao srmDao;
	@Override
	public List<SysRoadMgn> getAllSysRoadMgn(String luduanquanxian) {
		List<SysRoadMgn> list = srmDao.getAllSysRoadMgn(luduanquanxian);
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
