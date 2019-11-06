package com.ldxx.service;

import java.util.List;

import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.vo.PlanProductionCollectionVo;

public interface ShengChanJiHuaService {
	
	List<PlanProductionCollectionVo> getShengChanJiHuaListByCondition();
}
