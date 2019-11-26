package com.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.WhWarehouseCount;

public interface WhWarehouseCountDao {
	
	List<WhWarehouseCount> getAllWhWarehouseCount();
	
	WhWarehouseCount getWhWarehouseCountById(@Param("id")String id);
	
	int updWhWarehouseCountById(@Param("wwc")WhWarehouseCount wwc);
	
	int delWhWarehouseCountById(@Param("id")String id);
	
	int insertWhWarehouseCount(@Param("wwc")WhWarehouseCount wwc);
	
	WhWarehouseCount getWhWarehouseCountByStorNo(@Param("storNo")String storNo);

}
