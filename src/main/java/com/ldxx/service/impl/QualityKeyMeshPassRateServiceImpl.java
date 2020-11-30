package com.ldxx.service.impl;

import com.ldxx.bean.QualityJiPei;
import com.ldxx.bean.QualityKeyMeshPassRate;
import com.ldxx.dao.QualityKeyMeshPassRateDao;
import com.ldxx.service.QualityKeyMeshPassRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualityKeyMeshPassRateServiceImpl implements QualityKeyMeshPassRateService {

	@Autowired
	private QualityKeyMeshPassRateDao dao;

	@Override
	public List<QualityJiPei> getAllQualityKeyMeshPassRate() {
		List<QualityJiPei> list=dao.getAllQualityKeyMeshPassRate();
		return list;
	}

}
