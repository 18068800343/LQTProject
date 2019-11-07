package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.DicDeviceType;
import com.ldxx.dao.DicDeviceTypeDao;
import com.ldxx.service.DicDeviceTypeService;

@Service
@Transactional
public class DicDeviceTypeServiceImpl implements DicDeviceTypeService{

	@Autowired
	private DicDeviceTypeDao ddtDao;
	@Override
	public int addDicDeviceType(DicDeviceType dicDeviceType) {
		int state;
	/*	DicDeviceType d = ddtDao.selectByTypeName(dicDeviceType.getTypeName());
		if(null!=d&&null!=d.getTypeName())
		{*/
			state = ddtDao.addDicDeviceType(dicDeviceType);
		/* }else state =-1; */
		return state;
	}

	@Override
	public int updateDicDeviceType(DicDeviceType dicDeviceType) {
		int state;
	/*	DicDeviceType d = ddtDao.selectByTypeName(dicDeviceType.getTypeName());
		if(null!=d&&null!=d.getTypeName())
		{*/
			state  = ddtDao.updateDicDeviceType(dicDeviceType);
		/* }else state =-1; */
		return state;
	}

	@Override
	public List<DicDeviceType> selectAllDicDeviceType() {
		List<DicDeviceType>  list=ddtDao.selectAllDicDeviceType();
		return list;
	}

	@Override
	public int deleteDicDeviceType(String id) {
		int state = ddtDao.deleteDicDeviceType(id);
		return state;
	}

	@Override
	public DicDeviceType selectByTypeName(String typeName) {
		DicDeviceType d = ddtDao.selectByTypeName(typeName);
		return d;
	}

}
