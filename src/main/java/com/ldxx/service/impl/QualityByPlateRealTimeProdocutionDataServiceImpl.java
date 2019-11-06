package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldxx.bean.QualityByPlateRealTimeProdocutionData;
import com.ldxx.dao.QualityByPlateRealTimeProdocutionDataDao;
import com.ldxx.service.QualityByPlateRealTimeProdocutionDataService;

@Service
public class QualityByPlateRealTimeProdocutionDataServiceImpl implements QualityByPlateRealTimeProdocutionDataService {

	@Autowired
	private QualityByPlateRealTimeProdocutionDataDao dao;
	
	@Override
	public List<QualityByPlateRealTimeProdocutionData> getAllQualityByPlateRealTimeProdocutionData() {
		return dao.getAllQualityByPlateRealTimeProdocutionData();
	}

}
