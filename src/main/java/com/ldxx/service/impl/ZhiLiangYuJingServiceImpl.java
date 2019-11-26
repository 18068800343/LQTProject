package com.ldxx.service.impl;

import com.ldxx.Constant.BeanConstant;
import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.PlanProductionCount;
import com.ldxx.bean.User;
import com.ldxx.bean.WhWasteMgn;
import com.ldxx.dao.JiHuaZengJianDao;
import com.ldxx.dao.WhWasteMgnDao;
import com.ldxx.dao.ZhiLiangYuJingDao;
import com.ldxx.service.ZhiLiangYuJingService;
import com.ldxx.util.DateUtil;
import com.ldxx.util.LDXXUtils;
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

	@Resource
	private JiHuaZengJianDao jiHuaZengJianDao;

	@Resource
	private WhWasteMgnDao whWasteMgnDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateZhiLiangYuJingStatusService(PlanProductionWarningVo planProductionWarningVo, HttpSession session) {

		WhWasteMgn whWasteMgn = new WhWasteMgn();
		PlanProductionCount planProductionCount = new PlanProductionCount();

		User user = (User) session.getAttribute("user");
		Optional.ofNullable(user)
				.ifPresent(u->{
					planProductionWarningVo.setSenduserid(user.getUserId());
					whWasteMgn.setDealUserId(user.getUserId());
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



		String dateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19,new Date());
		String dateStrW = DateUtil.getDateStrByPattern(DateConstant.DATE14_,new Date());
		//初始化废料
		whWasteMgn.setId(LDXXUtils.getUUID12());
		whWasteMgn.setWasteNo("FL"+dateStrW);
		whWasteMgn.setPlanId(planProductionWarningVo.getPlanid());
		whWasteMgn.setPitchWeight(planProductionWarningVo.getPitchweight());
		whWasteMgn.setPitchType(planProductionWarningVo.getRecipeid());
		whWasteMgn.setUnitPrice(planProductionWarningVo.getPrice());
		whWasteMgn.setReason(planProductionWarningVo.getWarningcontent());
		whWasteMgn.setWarningState(BeanConstant.warningState1);
		whWasteMgn.setDealTime(dateStr);
		whWasteMgn.setDeleteState(1);
		//初始化生产计划产量表
		planProductionCount.setDatetime(dateStr);
		planProductionCount.setId(LDXXUtils.getUUID12());
		planProductionCount.setPlanid(planProductionWarningVo.getPlanid());
		planProductionCount.setPdneedincordec(whWasteMgn.getPitchWeight());
		planProductionCount.setPdneedsourcestate(1);
		int i = 0;
		int j = 0;
		int k = 0;
		try {
			i = dao.updateZhiLiangYuJingStatus(planProductionWarningVo);
		    j = whWasteMgnDao.insertWhWasteMgn(whWasteMgn);
		    k = jiHuaZengJianDao.addJiHuaZengJian(planProductionCount);
		    if(i>0&&j>0&&k>0){
		    	//return i;
			}else{
		    	i=-1;
		    	throw new Exception("废料失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
