package com.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.DicDeviceType;

public interface DicDeviceTypeService {

	public int addDicDeviceType(DicDeviceType dicDeviceType);
	
	public int updateDicDeviceType(DicDeviceType dicDeviceType);
	
	public List<DicDeviceType> selectAllDicDeviceType();
	
	public int deleteDicDeviceType(String id);
	
	public DicDeviceType selectByTypeName(String typeName);
}
