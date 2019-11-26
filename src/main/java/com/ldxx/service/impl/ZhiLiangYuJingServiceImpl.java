package com.ldxx.service.impl;

import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.User;
import com.ldxx.dao.ZhiLiangYuJingDao;
import com.ldxx.service.ZhiLiangYuJingService;
import com.ldxx.util.DateUtil;
import com.ldxx.vo.PlanProductionWarningVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Optional;


@Service
public class ZhiLiangYuJingServiceImpl implements ZhiLiangYuJingService {

	@Resource
	private ZhiLiangYuJingDao dao;




	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateZhiLiangYuJingStatusService(PlanProductionWarningVo planProductionWarningVo, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Optional.ofNullable(user)
				.ifPresent(u->{
					planProductionWarningVo.setSenduserid(user.getUserId());
				});
		String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		planProductionWarningVo.setSendtime(nowDateStr);
		String id = planProductionWarningVo.getId();
		Integer status = planProductionWarningVo.getSendstatus();
		Integer nextStatus = 0;
		switch(status){
			case 1:
				nextStatus = status+1;
				break;
			case 2:
				nextStatus = status+1;

				break;
			case 3:
				nextStatus = status+1;
				break;
			default:
				break;
		}
		planProductionWarningVo.setSendstatus(nextStatus);
		int i = 0;
		try {
			i = dao.updateZhiLiangYuJingStatus(planProductionWarningVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
