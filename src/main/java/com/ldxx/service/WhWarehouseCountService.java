package com.ldxx.service;

import java.util.List;
import com.ldxx.bean.WhWarehouseCount;

public interface WhWarehouseCountService {
	
	List<WhWarehouseCount> getAllWhWarehouseCount();
	
	WhWarehouseCount getWhWarehouseCountById(String id);
	
	int updWhWarehouseCountById(WhWarehouseCount wwc);
	
	int delWhWarehouseCountById(String id);
	
	int insertWhWarehouseCount(WhWarehouseCount wwc);

}
