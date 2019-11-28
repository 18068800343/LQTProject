package com.ldxx.service.impl;

import com.ldxx.bean.SiteConstruction;
import com.ldxx.dao.TanPuDiDianGuanLiDao;
import com.ldxx.service.TanPuDiDianGuanLiService;
import com.ldxx.vo.SiteConstructionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TanPuDiDianGuanLiServiceImpl implements TanPuDiDianGuanLiService{
	
	@Autowired
	private TanPuDiDianGuanLiDao dao;

	@Override
	public List<SiteConstruction> getDistinctTanPuDiDian() {
		// TODO Auto-generated method stub
		return dao.getDistinctTanPuDiDian();
	}

	@Override
	public List<SiteConstruction> getBiaoDuanByLuDuan(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.getBiaoDuanByLuDuan(map);
	}

	@Override
	public List<SiteConstructionVo> getByLuDuanId(Map<String, String> map) {
		return dao.getByLuDuanId(map);
	}

}
