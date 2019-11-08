package com.ldxx.service;

import java.util.List;


import com.ldxx.bean.TruckInfo;

public interface TruckInfoService {
	
	List<TruckInfo> getAllTruckInfo();
	
	TruckInfo getTruckInfoById(String id);
	
	int updTruckInfo(TruckInfo t);
	
	int delTruckInfo(String id);
	
	int insertTruckInfo(TruckInfo t);

}
