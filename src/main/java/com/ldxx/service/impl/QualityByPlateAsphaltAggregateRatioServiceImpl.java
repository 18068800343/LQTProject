package com.ldxx.service.impl;

import com.ldxx.bean.QualityByPlateAsphaltAggregateRatio;
import com.ldxx.dao.QualityByPlateAsphaltAggregateRatioDao;
import com.ldxx.service.QualityByPlateAsphaltAggregateRatioService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QualityByPlateAsphaltAggregateRatioServiceImpl implements QualityByPlateAsphaltAggregateRatioService {

	@Resource
	private QualityByPlateAsphaltAggregateRatioDao dao;
	
	@Override
	public List<QualityByPlateAsphaltAggregateRatio> getAllQualityByPlateAsphaltAggregateRatio() {
		// TODO Auto-generated method stub
		List<QualityByPlateAsphaltAggregateRatio> list =  dao.getAllQualityByPlateAsphaltAggregateRatio();
		return list;
	}

}
