package com.ldxx.service.impl;

import com.ldxx.bean.Accessory;
import com.ldxx.bean.DeviceInfo;
import com.ldxx.bean.DicDeviceType;
import com.ldxx.dao.AccessoryDao;
import com.ldxx.dao.DeviceInfoDao;
import com.ldxx.dao.DicDeviceTypeDao;
import com.ldxx.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeviceInfoServiceImpl implements DeviceInfoService{

	@Autowired
	DeviceInfoDao didao;
	@Autowired
	DicDeviceTypeDao ddtdao;
	@Autowired
	private AccessoryDao accessoryDao;
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
		state = didao.addDeviceInfo(deviceInfo);
		if(state>0){
			List<Accessory> accessory = deviceInfo.getAccessory();
			if(accessory!=null&&accessory.size()!=0){
				accessoryDao.addAccessory(accessory);
			}
		}
		return state;
	}

	@Override
	public int updateDeviceInfo(DeviceInfo deviceInfo) {
		int state;
		state = didao.updateDeviceInfo(deviceInfo);
		if(state>0){
			List<Accessory> accessory = deviceInfo.getAccessory();
			if(accessory!=null&&accessory.size()!=0){
				accessoryDao.addAccessory(accessory);
			}
		}
		return state;
	}

	@Override
	public int deleteDeviceInfo(String id) {
		int state;
		state = didao.deleteDeviceInfo(id);
		return state;
	}

}
