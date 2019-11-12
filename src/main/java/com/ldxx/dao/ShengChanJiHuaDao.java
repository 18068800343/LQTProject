package com.ldxx.dao;

import java.util.List;

import com.ldxx.bean.PlanConstructionDeviation;
import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.vo.PlanConstructionDeviationVo;
import com.ldxx.vo.PlanProductionCollectionVo;

public interface  ShengChanJiHuaDao {
	
	List<PlanProductionCollectionVo> getShengChanJiHuaListByCondition();
	
	List<PlanConstructionDeviationVo> getAllShiGongPianCha();
	
	PlanConstructionDeviationVo getPianChaById(String id);
	
	int addShengChanJiHua(PlanProductionCollection planProductionCollection);
	
	int addShiGongPianCha(PlanConstructionDeviation planConstructionDeviation);
	
	int updateShiGongPianCha(PlanConstructionDeviation planConstructionDeviation);
	
	int updateShengChanJiHua(PlanProductionCollection planProductionCollection);
	
	int delShengChanJiHuaById(String planid);
	
	int delShiGongPianChaById(String id);
	
	int linkShiGongPianCha(String planid,String pianchaid);
	
}
