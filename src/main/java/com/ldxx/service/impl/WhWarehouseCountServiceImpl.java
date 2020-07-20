package com.ldxx.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.WhWarehouseCount;
import com.ldxx.dao.WhWarehouseCountDao;
import com.ldxx.service.WhWarehouseCountService;

@Service
public class WhWarehouseCountServiceImpl implements WhWarehouseCountService {

	
	@Autowired
	private WhWarehouseCountDao dao;
	
	@Override
	public List<WhWarehouseCount> getAllWhWarehouseCount() {
		return dao.getAllWhWarehouseCount();
	}

	@Override
	public WhWarehouseCount getWhWarehouseCountById(String id) {
		return dao.getWhWarehouseCountById(id);
	}

	@Override
	@Transactional
	public int updWhWarehouseCountById(WhWarehouseCount wwc) {
		return dao.updWhWarehouseCountById(wwc);
	}

	@Override
	@Transactional
	public int delWhWarehouseCountById(String id) {
		return dao.delWhWarehouseCountById(id);
	}

	@Override
	@Transactional
	public int insertWhWarehouseCount(WhWarehouseCount wwc) {
		BigDecimal tiji = wwc.getTiji();
		BigDecimal weight = wwc.getWeight();
		if (null != tiji && null == weight) {
			weight = tiji.multiply(new BigDecimal(1.5));
			wwc.setWeight(weight);
		}
		return dao.insertWhWarehouseCount(wwc);
	}

	@Override
	public WhWarehouseCount getWhWarehouseCountByStorNo(String storNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
