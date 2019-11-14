package com.ldxx.service;

import java.util.List;

import com.ldxx.bean.DeviceInfo;


public interface DeviceInfoService {

	public List<DeviceInfo> selectAllDeviceInfo();
	
	public DeviceInfo selectByIdDeviceInfo(String id);
	
	public int addDeviceInfo(DeviceInfo deviceInfo);
	
	public int updateDeviceInfo(DeviceInfo deviceInfo);
	
	public int deleteDeviceInfo(String id);
	
}
