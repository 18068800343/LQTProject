package com.ldxx.dao;

import com.ldxx.bean.QualityRealtimeDeviation;

import java.util.List;

public interface QualityRealtimeDeviationDao {
	
	List<QualityRealtimeDeviation> getAllQualityRealtimeDeviation();


	List<QualityRealtimeDeviation> getPianChaVoListByTime(String beginTime, String endTime);

}
