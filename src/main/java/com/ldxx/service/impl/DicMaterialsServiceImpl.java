package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.DicMaterials;
import com.ldxx.dao.DicMaterialsDao;
import com.ldxx.service.DicMaterialsService;

@Service
@Transactional
public class DicMaterialsServiceImpl implements DicMaterialsService{

	@Autowired
	private DicMaterialsDao dicmDao;
	
	@Override
	public List<DicMaterials> selectAllDicMaterials() {
		 List<DicMaterials> list =  dicmDao.selectAllDicMaterials();
		return list;
	}

	@Override
	public int addDicMaterials(DicMaterials dicMaterials) {
		int state=0;
		DicMaterials d = dicmDao.selectByName(dicMaterials.getMaterialName());
		if(null!=d&&null!=d.getMaterialName())
		{
			state=-1;
		}else {
			state = dicmDao.addDicMaterials(dicMaterials);
		}
		return state;
	}

	@Override
	public int deleteDicMaterials(String id) {
		int state = dicmDao.deleteDicMaterials(id);
		return state;
	}

	@Override
	public int updateDicMaterials(DicMaterials dicMaterials) {
		int state=0;
		DicMaterials d = dicmDao.selectByName(dicMaterials.getMaterialName());
		if(null!=d&&null!=d.getMaterialName())
		{
			state=-1;
		}else {
			state = dicmDao.updateDicMaterials(dicMaterials);
		}
		return state;
	}


}
