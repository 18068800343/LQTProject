package com.ldxx.service;

import com.ldxx.bean.Accessory;

import java.util.List;

public interface AccessoryService {

	public int addAccessory(List<Accessory> accessory);
	
	public int deleteAccessory(String id);
	
	public List<Accessory> selectAccessoryById(String id);
	
	public int deleteAccessoryByIdAndName(Accessory accessory);
	
	public List<Accessory> selectAccessoryByIdAndType(String id, String type);
	
	public int fileCount(String id);
	
}
