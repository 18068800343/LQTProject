package com.ldxx.dao;

import com.ldxx.bean.PageUtil;
import com.ldxx.bean.QualityByPlateAsphaltAggregateRatio;

import java.util.List;

public interface QualityByPlateAsphaltAggregateRatioDao {

	List<QualityByPlateAsphaltAggregateRatio> getAllQualityByPlateAsphaltAggregateRatio();

	List<QualityByPlateAsphaltAggregateRatio> getAllQualityByPageCondition(PageUtil pageUtil);

	Integer getQualityCount(PageUtil pageUtil);

	List<QualityByPlateAsphaltAggregateRatio> getYouShiBiVoListByTime(String beginTime, String endTime, String peifang);

	List<QualityByPlateAsphaltAggregateRatio> getDistincePeiFangByTime(String beginTime, String endTime);

}
