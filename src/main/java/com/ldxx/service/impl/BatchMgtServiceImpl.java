package com.ldxx.service.impl;

import java.util.List;

import com.ldxx.vo.BatchMgtVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.BatchMgt;
import com.ldxx.dao.BatchMgtDao;
import com.ldxx.service.BatchMgtService;

@Service
public class BatchMgtServiceImpl implements BatchMgtService {

	@Autowired
	private BatchMgtDao dao;
	
	@Override
	public List<BatchMgtVo> getAllBatchMgt() {
		// TODO Auto-generated method stub
		return dao.getAllBatchMgt();
	}

	@Override
	public BatchMgt getBatchMgtById(String id) {
		// TODO Auto-generated method stub
		return dao.getBatchMgtById(id);
	}

	@Override
	@Transactional
	public int updBatchMgt(BatchMgt bm) {
		// TODO Auto-generated method stub
		return dao.updBatchMgt(bm);
	}

	@Override
	@Transactional
	public int delBatchMgt(String id) {
		// TODO Auto-generated method stub
		return dao.delBatchMgt(id);
	}

	@Override
	@Transactional
	public int insertBatchMgt(BatchMgt bm) {
		// TODO Auto-generated method stub
		return dao.insertBatchMgt(bm);
	}

	@Override
	public BatchMgt getBatchMgtByPlate(String licencePlate) {
		return dao.getBatchMgtByPlate(licencePlate);
	}

}
