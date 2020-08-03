package com.ldxx.dao;

import com.ldxx.bean.PlanConstructionDeviation;
import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.bean.PlanProductionCount;
import com.ldxx.vo.*;

import java.util.List;

public interface ShengChanJiHuaDao {

    List<PlanProductionCollectionVo> getShengChanJiHuaListByCondition();

    List<PlanProductionCollectionVo> getShengChanJiHuaListByTime(String time);

    List<PlanConstructionDeviationVo> getAllShiGongPianCha();

    PlanConstructionDeviationVo getPianChaById(String id);

    PlanProductionCollectionVo getShengChanJiHuaNow();

    int addShengChanJiHua(PlanProductionCollection planProductionCollection);

    int emptyShengChanJiHua();

    int addShengChanJiHuaCurrent(PlanProductionCollection planProductionCollection);

    int addShengChanJiHuaVo(PlanProductionVo planProductionVo);

    PlanProductionCollection getShengChanJiHuaById(String id);

    int addShiGongPianCha(PlanConstructionDeviation planConstructionDeviation);

    int updateShiGongPianCha(PlanConstructionDeviation planConstructionDeviation);

    int updateShengChanJiHua(PlanProductionCollection planProductionCollection);

	int updateShengChanJiHuaVo(PlanProductionVo planProductionVo);

	int delShengChanJiHuaById(String planid);

	int delShiGongPianChaById(String id);

	int linkShiGongPianCha(String planid, String pianchaid);

	int addPlanProductionCount(PlanProductionCount planProductionCount);

	PianChaLiangVo getPiancha(SiteFieldMaterialMgtVo siteFieldMaterialMgtVo);

    List<PlanProductionCollectionVo> getCountByfinishTime(String startime, String endTime);

    List<PlanProductionCollectionVo> xggetCountByfinishTime(String startime, String endTime,String id);

    PlanProductionCollectionVo getBysiteId(String id);
}
