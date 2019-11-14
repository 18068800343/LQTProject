package com.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.DeviceInfo;

public interface DeviceInfoDao {

	public List<DeviceInfo> selectAllDeviceInfo();
	
	public DeviceInfo selectByIdDeviceInfo(String id);
	
	public int addDeviceInfo(@Param("deviceInfo") DeviceInfo deviceInfo);
	
	public int updateDeviceInfo(@Param("deviceInfo") DeviceInfo deviceInfo);
	
	public int deleteDeviceInfo(String id);
	
}
