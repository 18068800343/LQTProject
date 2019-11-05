package com.ldxx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.SysWarningSet;
import com.ldxx.dao.SysWarningSetDao;
import com.ldxx.service.SysWarningSetService;
import com.ldxx.util.LDXXUtils;

@Service
public class SysWarningSetServiceImpl implements SysWarningSetService {

	@Autowired
	private SysWarningSetDao dao;
	
	@Transactional
	@Override
	public int addSysWarningSet(SysWarningSet ss) {
		int i = dao.addSysWarningSet(ss);
		return i;
	}

	@Transactional
	@Override
	public int updateSysWarningSetById(SysWarningSet ss) {
		int i = dao.updateSysWarningSetById(ss);
		return i;
	}

	@Override
	public List<SysWarningSet> getAllSysWarningSet() {
		List<SysWarningSet> list = dao.getAllSysWarningSet();
		return list;
	}

	@Transactional
	@Override
	public int delSysWarningSet(String id) {
		int i = dao.delSysWarningSet(id);
		return i;
	}

}
