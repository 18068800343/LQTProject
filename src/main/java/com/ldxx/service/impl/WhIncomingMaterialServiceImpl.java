package com.ldxx.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.WhIncomingMaterial;
import com.ldxx.bean.WhWarehouseCount;
import com.ldxx.dao.WhIncomingMaterialDao;
import com.ldxx.dao.WhWarehouseCountDao;
import com.ldxx.service.WhIncomingMaterialService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;

@Service
public class WhIncomingMaterialServiceImpl implements WhIncomingMaterialService {

	@Autowired
	private WhIncomingMaterialDao dao;
	
	//仓储管理dao
	@Autowired
	private WhWarehouseCountDao wwcDao;
	@Override
	public List<WhIncomingMaterial> getAllWhIncomingMaterial(String beginTime, String endTime) {
		return dao.getAllWhIncomingMaterial(beginTime, endTime);
	}

	@Override
	public WhIncomingMaterial getWhIncomingMaterialById(String id) {
		return dao.getWhIncomingMaterialById(id);
	}

	@Transactional
	@Override
	public int updWhIncomingMaterialById(WhIncomingMaterial wm) {
		WhWarehouseCount wwc = wwcDao.getWhWarehouseCountByStorNo(wm.getStorNo());
		if (!wwc.getMaterials().equals(wm.getMaterials())) {
			//如果进料材料类型和料仓对应不上，则不能插入数据
			return -3;
		}
		return dao.updWhIncomingMaterialById(wm);
	}

	@Transactional
	@Override
	public int delWhIncomingMaterialById(String id) {
		return dao.delWhIncomingMaterialById(id);
	}

	@Transactional
	@Override
	public int insertWhIncomingMaterial(WhIncomingMaterial wm) {
		//插入进料信息的同时插入一条仓库记录start
		Date date = new Date();
		WhWarehouseCount wwc = wwcDao.getWhWarehouseCountByStorNo(wm.getStorNo());
		if(null==wwc)
		{
			wwc = new WhWarehouseCount();
			wwc.setId(LDXXUtils.getUUID12());
			wwc.setStorNo(wm.getStorNo());
			wwc.setDatetime(date);
			wwc.setWeight(new BigDecimal(wm.getWeight()));
			wwc.setMaterials(wm.getMaterials());
			wwc.setEditUserId2(wm.getEditUserId());
			wwc.setEditDatetime2(wm.getEditDatetime());
			wwc.setDeleteState(1);
			wwcDao.insertWhWarehouseCount(wwc);	
		}else if(!wwc.getMaterials().equals(wm.getMaterials())){
			//如果进料材料类型和料仓对应不上，则不能插入数据
			return -3;
		}else{
			wwc.setWeight(new BigDecimal(wwc.getWeight().doubleValue()+wm.getWeight()));
			wwc.setDatetime(date);
			wwc.setEditDatetime2(wm.getEditDatetime());
			wwc.setEditUserId2(wm.getEditUserId());
			wwcDao.updWhWarehouseCountById(wwc);
		}
		//插入进料信息的同时插入一条仓库记录end
		int state =dao.insertWhIncomingMaterial(wm);
		return state;
	}

}
