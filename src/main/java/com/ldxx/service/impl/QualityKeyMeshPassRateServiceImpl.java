package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldxx.bean.QualityKeyMeshPassRate;
import com.ldxx.dao.QualityKeyMeshPassRateDao;
import com.ldxx.service.QualityKeyMeshPassRateService;

@Service
public class QualityKeyMeshPassRateServiceImpl implements QualityKeyMeshPassRateService {

	@Autowired
	private QualityKeyMeshPassRateDao dao;

	@Override
	public List<QualityKeyMeshPassRate> getAllQualityKeyMeshPassRate() {
		List<QualityKeyMeshPassRate> list=dao.getAllQualityKeyMeshPassRate();
		return list;
	}

}
