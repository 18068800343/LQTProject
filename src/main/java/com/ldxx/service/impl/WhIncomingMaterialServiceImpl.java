package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.WhIncomingMaterial;
import com.ldxx.dao.WhIncomingMaterialDao;
import com.ldxx.service.WhIncomingMaterialService;

@Service
public class WhIncomingMaterialServiceImpl implements WhIncomingMaterialService {

	@Autowired
	private WhIncomingMaterialDao dao;
	
	@Override
	public List<WhIncomingMaterial> getAllWhIncomingMaterial() {
		return dao.getAllWhIncomingMaterial();
	}

	@Override
	public WhIncomingMaterial getWhIncomingMaterialById(String id) {
		return dao.getWhIncomingMaterialById(id);
	}

	@Transactional
	@Override
	public int updWhIncomingMaterialById(WhIncomingMaterial wm) {
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
		return dao.insertWhIncomingMaterial(wm);
	}

}
