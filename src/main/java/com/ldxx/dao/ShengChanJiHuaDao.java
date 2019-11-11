package com.ldxx.dao;

import java.util.List;

import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.vo.PlanConstructionDeviationVo;
import com.ldxx.vo.PlanProductionCollectionVo;

public interface  ShengChanJiHuaDao {
	
	List<PlanProductionCollectionVo> getShengChanJiHuaListByCondition();
	
	List<PlanConstructionDeviationVo> getAllShiGongPianCha();
	
	int addShengChanJiHua(PlanProductionCollection planProductionCollection);
	
	int updateShengChanJiHua(PlanProductionCollection planProductionCollection);
	
}
