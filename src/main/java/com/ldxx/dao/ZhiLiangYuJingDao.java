package com.ldxx.dao;

import com.ldxx.vo.PlanProductionWarningVo;

import java.util.List;

public interface ZhiLiangYuJingDao {


	List<PlanProductionWarningVo> getAllZhiLiangYuJing();


	int addZhiLiangYuJing(PlanProductionWarningVo planProductionWarningVo);

	int delZhiLiangYuJing(String id);

	int updateZhiLiangYuJing(PlanProductionWarningVo planProductionWarningVo);

	int updateZhiLiangYuJingStatus(PlanProductionWarningVo planProductionWarningVo);

}
