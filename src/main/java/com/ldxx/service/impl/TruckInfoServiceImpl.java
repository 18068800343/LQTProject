package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.TruckInfo;
import com.ldxx.dao.TruckInfoDao;
import com.ldxx.service.TruckInfoService;

@Service
public class TruckInfoServiceImpl implements TruckInfoService {

	@Autowired
	private TruckInfoDao dao;
	
	@Override
	public List<TruckInfo> getAllTruckInfo() {
		return dao.getAllTruckInfo();
	}

	@Override
	public TruckInfo getTruckInfoById(String id) {
		// TODO Auto-generated method stub
		return dao.getTruckInfoById(id);
	}

	@Override
	@Transactional
	public int updTruckInfo(TruckInfo t) {
		// TODO Auto-generated method stub
		return dao.updTruckInfo(t);
	}

	@Override
	@Transactional
	public int delTruckInfo(String id) {
		// TODO Auto-generated method stub
		return dao.delTruckInfo(id);
	}

	@Override
	@Transactional
	public int insertTruckInfo(TruckInfo t) {
		// TODO Auto-generated method stub
		return dao.insertTruckInfo(t);
	}

}
