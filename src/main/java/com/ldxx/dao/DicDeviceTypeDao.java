package com.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.DicDeviceType;

public interface DicDeviceTypeDao {

	public int addDicDeviceType(@Param("dicDeviceType")DicDeviceType dicDeviceType);
	
	public int updateDicDeviceType(@Param("dicDeviceType")DicDeviceType dicDeviceType);
	
	public List<DicDeviceType> selectAllDicDeviceType();
	
	public int deleteDicDeviceType(String id);
	
	public DicDeviceType selectByTypeName(@Param("typeName")String typeName);
	
	public DicDeviceType selectByIdDicDeviceType(String id);
}
