package com.ldxx.dao;

import com.ldxx.bean.QualityByPlateAsphaltAggregateRatio;

import java.util.List;

public interface QualityByPlateAsphaltAggregateRatioDao {
	
	List<QualityByPlateAsphaltAggregateRatio> getAllQualityByPlateAsphaltAggregateRatio();

	List<QualityByPlateAsphaltAggregateRatio> getYouShiBiVoListByTime(String beginTime, String endTime);

}
