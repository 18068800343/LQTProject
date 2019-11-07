package com.ldxx.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.bean.SiteConstruction;
import com.ldxx.bean.User;
import com.ldxx.dao.ShengChanJiHuaDao;
import com.ldxx.dao.TanPuDiDianGuanLiDao;
import com.ldxx.dao.UserDao;
import com.ldxx.service.ShengChanJiHuaService;
import com.ldxx.service.TanPuDiDianGuanLiService;
import com.ldxx.service.UserService;
import com.ldxx.vo.PlanProductionCollectionVo;

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

}
