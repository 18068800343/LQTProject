package com.ldxx.dao;

import com.ldxx.bean.QualityByPlateRealTimeProdocutionData;

import java.util.List;

public interface QualityByPlateRealTimeProdocutionDataDao {
	
	List<QualityByPlateRealTimeProdocutionData> getAllQualityByPlateRealTimeProdocutionData();

	List<QualityByPlateRealTimeProdocutionData> getPeiBiVoListByTime(String beginTime, String endTime);
}
