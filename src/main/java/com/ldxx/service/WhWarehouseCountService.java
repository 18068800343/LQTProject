package com.ldxx.service;

import java.util.List;
import com.ldxx.bean.WhWarehouseCount;

public interface WhWarehouseCountService {
	
	public List<WhWarehouseCount> getAllWhWarehouseCount();
	
	WhWarehouseCount getWhWarehouseCountById(String id);
	
	int updWhWarehouseCountById(WhWarehouseCount wwc);
	
	int delWhWarehouseCountById(String id);
	
	int insertWhWarehouseCount(WhWarehouseCount wwc);

	WhWarehouseCount getWhWarehouseCountByStorNo(String storNo);
}
