package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldxx.bean.QualityRealtimeDeviation;
import com.ldxx.dao.QualityRealtimeDeviationDao;
import com.ldxx.service.QualityRealtimeDeviationService;

@Service
public class QualityRealtimeDeviationServiceImpl implements QualityRealtimeDeviationService {

	@Autowired
	private QualityRealtimeDeviationDao dao;
	
	@Override
	public List<QualityRealtimeDeviation> getAllQualityRealtimeDeviation() {
		return dao.getAllQualityRealtimeDeviation();
	}

}
