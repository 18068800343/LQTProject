package com.ldxx.dao;

import java.util.List;

import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.vo.PlanProductionCollectionVo;

public interface  ShengChanJiHuaDao {
	
	List<PlanProductionCollectionVo> getShengChanJiHuaListByCondition();
	
	int addShengChanJiHua(PlanProductionCollection planProductionCollection);
	
}
