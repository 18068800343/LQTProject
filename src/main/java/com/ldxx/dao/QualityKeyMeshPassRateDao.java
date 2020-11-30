package com.ldxx.dao;

import com.ldxx.bean.QualityJiPei;

import java.util.List;

public interface QualityKeyMeshPassRateDao {
	
	List<QualityJiPei> getAllQualityKeyMeshPassRate();

	List<QualityJiPei> getTongGuoLvVoListByTime(String beginTime, String endTime, String peifang);

	List<QualityJiPei> getDISTINCTPeiFangByTime(String beginTime, String endTime);
}
