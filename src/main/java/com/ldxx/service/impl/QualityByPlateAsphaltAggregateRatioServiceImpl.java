package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldxx.bean.QualityByPlateAsphaltAggregateRatio;
import com.ldxx.dao.QualityByPlateAsphaltAggregateRatioDao;
import com.ldxx.service.QualityByPlateAsphaltAggregateRatioService;

@Service
public class QualityByPlateAsphaltAggregateRatioServiceImpl implements QualityByPlateAsphaltAggregateRatioService {

	@Autowired
	private QualityByPlateAsphaltAggregateRatioDao dao;
	
	@Override
	public List<QualityByPlateAsphaltAggregateRatio> getAllQualityByPlateAsphaltAggregateRatio() {
		// TODO Auto-generated method stub
		return dao.getAllQualityByPlateAsphaltAggregateRatio();
	}

}
