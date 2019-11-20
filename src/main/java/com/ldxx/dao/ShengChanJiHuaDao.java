package com.ldxx.dao;

import com.ldxx.bean.PlanConstructionDeviation;
import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.bean.PlanProductionCount;
import com.ldxx.vo.PianChaLiangVo;
import com.ldxx.vo.PlanConstructionDeviationVo;
import com.ldxx.vo.PlanProductionCollectionVo;
import com.ldxx.vo.SiteFieldMaterialMgtVo;

import java.util.List;

public interface  ShengChanJiHuaDao {
	
	List<PlanProductionCollectionVo> getShengChanJiHuaListByCondition();
	
	List<PlanConstructionDeviationVo> getAllShiGongPianCha();
	
	PlanConstructionDeviationVo getPianChaById(String id);
	
	int addShengChanJiHua(PlanProductionCollection planProductionCollection);

	PlanProductionCollection getShengChanJiHuaById(String id);

	int addShiGongPianCha(PlanConstructionDeviation planConstructionDeviation);
	
	int updateShiGongPianCha(PlanConstructionDeviation planConstructionDeviation);
	
	int updateShengChanJiHua(PlanProductionCollection planProductionCollection);
	
	int delShengChanJiHuaById(String planid);
	
	int delShiGongPianChaById(String id);
	
	int linkShiGongPianCha(String planid,String pianchaid);
	
	int addPlanProductionCount(PlanProductionCount planProductionCount);

	PianChaLiangVo getPiancha(SiteFieldMaterialMgtVo siteFieldMaterialMgtVo);
}
