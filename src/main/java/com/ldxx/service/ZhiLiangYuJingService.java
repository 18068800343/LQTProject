package com.ldxx.service;

import com.ldxx.vo.PlanProductionWarningVo;

import javax.servlet.http.HttpSession;

public interface ZhiLiangYuJingService {

	public int updateZhiLiangYuJingStatusService(PlanProductionWarningVo planProductionWarningVo, HttpSession session);

}
