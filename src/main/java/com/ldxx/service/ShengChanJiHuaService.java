package com.ldxx.service;

import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.bean.SiteConstruction;
import com.ldxx.vo.PlanProductionCollectionVo;
import com.ldxx.vo.PlanProductionVo;
import com.ldxx.vo.SiteConstructionVo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ShengChanJiHuaService {

	List<PlanProductionCollectionVo> getShengChanJiHuaListByCondition();

	String addShengChanJiHua(PlanProductionCollection planProductionCollection, HttpSession session);

	String addShengChanJiHuaAndSiteConstruction(PlanProductionVo planProductionVo, HttpSession session);

	String updateShengChanJiHua(PlanProductionCollection planProductionCollection, HttpSession session);

	String updateShengChanJiHuaVo(PlanProductionVo planProductionVo, HttpSession session);
}
