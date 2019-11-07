package com.ldxx.service.impl;

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
		return dao.insertWhWarehouseCount(wwc);
	}

}
