package com.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.TruckInfo;

public interface TruckInfoDao {

	List<TruckInfo> getAllTruckInfo();
	
	TruckInfo getTruckInfoById(@Param("id")String id);
	
	int updTruckInfo(@Param("t")TruckInfo t);
	
	int delTruckInfo(@Param("id")String id);
	
	int insertTruckInfo(@Param("t")TruckInfo t);
}
