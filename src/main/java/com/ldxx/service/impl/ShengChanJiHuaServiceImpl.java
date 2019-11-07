package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.bean.User;
import com.ldxx.dao.ShengChanJiHuaDao;
import com.ldxx.dao.UserDao;
import com.ldxx.service.ShengChanJiHuaService;
import com.ldxx.service.UserService;
import com.ldxx.vo.PlanProductionCollectionVo;

@Service
@Transactional
public class ShengChanJiHuaServiceImpl implements ShengChanJiHuaService{
	
	@Autowired
	private ShengChanJiHuaDao dao;

	@Override
	public List<PlanProductionCollectionVo> getShengChanJiHuaListByCondition(){
		// TODO Auto-generated method stub
		return dao.getShengChanJiHuaListByCondition();
	}

	@Override
	public int addShengChanJiHua(PlanProductionCollection planProductionCollection) {
		// TODO Auto-generated method stub
		return dao.addShengChanJiHua(planProductionCollection);
	}
}
