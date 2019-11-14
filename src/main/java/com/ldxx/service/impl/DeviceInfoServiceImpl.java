package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.DeviceInfo;
import com.ldxx.bean.DicDeviceType;
import com.ldxx.dao.DeviceInfoDao;
import com.ldxx.dao.DicDeviceTypeDao;
import com.ldxx.service.DeviceInfoService;
import com.ldxx.util.LDXXUtils;

@Service
@Transactional
public class DeviceInfoServiceImpl implements DeviceInfoService{

	@Autowired
	DeviceInfoDao didao;
	@Autowired
	DicDeviceTypeDao ddtdao;
	@Override
	public List<DeviceInfo> selectAllDeviceInfo() {
		List<DeviceInfo> list = didao.selectAllDeviceInfo();
		List<DicDeviceType> ddtlist = ddtdao.selectAllDicDeviceType();
		for(int i=0;i<list.size();i++)
		{
			for(int j=0;j<ddtlist.size();j++)
			{
				if(list.get(i).getTypeId().equals(ddtlist.get(j).getId()))
				{
					DicDeviceType ddt = new DicDeviceType();
					ddt.setId(ddtlist.get(j).getId());
					ddt.setTypeName(ddtlist.get(j).getTypeName());
					list.get(i).setDicDeviceType(ddt);
					break;
				}
			}
		}
		return list;
	}

	@Override
	public DeviceInfo selectByIdDeviceInfo(String id) {
		DeviceInfo d = didao.selectByIdDeviceInfo(id);
		return d;
	}

	@Override
	public int addDeviceInfo(DeviceInfo deviceInfo) {
		int state;
		deviceInfo.setId(LDXXUtils.getUUID12());
		state = didao.addDeviceInfo(deviceInfo);
		return state;
	}

	@Override
	public int updateDeviceInfo(DeviceInfo deviceInfo) {
		int state;
		state = didao.updateDeviceInfo(deviceInfo);
		return state;
	}

	@Override
	public int deleteDeviceInfo(String id) {
		int state;
		state = didao.deleteDeviceInfo(id);
		return state;
	}

}
