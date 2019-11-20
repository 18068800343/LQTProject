package com.ldxx.service;

import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.vo.PlanProductionCollectionVo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ShengChanJiHuaService {
	
	List<PlanProductionCollectionVo> getShengChanJiHuaListByCondition();
	
	String addShengChanJiHua(PlanProductionCollection planProductionCollection, HttpSession session);

	String updateShengChanJiHua(PlanProductionCollection planProductionCollection, HttpSession session);
}
