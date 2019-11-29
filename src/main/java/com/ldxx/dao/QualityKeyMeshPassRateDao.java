package com.ldxx.dao;

import com.ldxx.bean.QualityKeyMeshPassRate;

import java.util.List;

public interface QualityKeyMeshPassRateDao {
	
	List<QualityKeyMeshPassRate> getAllQualityKeyMeshPassRate();

	List<QualityKeyMeshPassRate> getTongGuoLvVoListByTime(String beginTime, String endTime);
}
