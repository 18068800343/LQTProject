package com.ldxx.dao;

import com.ldxx.bean.PlanProductionCount;

import java.util.List;

public interface JiHuaZengJianDao {


	List<PlanProductionCount> getAllJiHuaZengJian();


	int addJiHuaZengJian(PlanProductionCount planProductionCount);

	int delJiHuaZengJian(String id);

	int updateJiHuaZengJian(PlanProductionCount planProductionCount);

}
