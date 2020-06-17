package com.ldxx.service.impl;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.bean.PlanProductionCount;
import com.ldxx.bean.SiteConstruction;
import com.ldxx.bean.User;
import com.ldxx.dao.JiHuaZengJianDao;
import com.ldxx.dao.ShengChanJiHuaDao;
import com.ldxx.dao.TanPuDiDianGuanLiDao;
import com.ldxx.service.ShengChanJiHuaService;
import com.ldxx.util.DateUtil;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.PlanProductionCollectionVo;
import com.ldxx.vo.PlanProductionVo;
import com.ldxx.vo.SiteConstructionVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ShengChanJiHuaServiceImpl implements ShengChanJiHuaService {

	@Resource
	private ShengChanJiHuaDao dao;

	@Resource
	private TanPuDiDianGuanLiDao tanPuDiDianGuanLiDao;

	@Resource
	private JiHuaZengJianDao jiHuaZengJianDao;

	@Override
	public List<PlanProductionCollectionVo> getShengChanJiHuaListByCondition() {
		// TODO Auto-generated method stub
		return dao.getShengChanJiHuaListByCondition();
	}

	@Transactional
	@Override
	public String addShengChanJiHua(PlanProductionCollection planProductionCollection, HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		String dateTime = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		String jhDateTime = DateUtil.getDateStrByPattern(DateConstant.DATE14_, new Date());
		String planno = planProductionCollection.getPlanno();
		planProductionCollection.setPlanno(planno+jhDateTime);
		planProductionCollection.setDatetime(dateTime);
		planProductionCollection.setEditdatetime(dateTime);
		planProductionCollection.setDeletestate(1);
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			planProductionCollection.setEdituserid(user.getUserId());;
		}
		String planId = LDXXUtils.getUUID12();
		planProductionCollection.setPlanid(planId);

		PlanProductionCount planProductionCount = new PlanProductionCount();
		planProductionCount.setDatetime(dateTime);
		planProductionCount.setId(LDXXUtils.getUUID12());
		planProductionCount.setPlanid(planId);
		planProductionCount.setPdneedincordec(planProductionCollection.getPdneed());
		planProductionCount.setPdneedsourcestate(1);
		try {

			int i = dao.addShengChanJiHua(planProductionCollection);
			jiHuaZengJianDao.addJiHuaZengJian(planProductionCount);

			String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
			jsonObject.put("resultMsg", daoMsg);
			jsonObject.put("daoMsg", i);
			jsonObject.put("obj", planProductionCollection);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = jsonObject.toString();
		return result;
	}

	@Override
	public String addShengChanJiHuaAndSiteConstruction(PlanProductionVo planProductionVo, HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		String dateTime = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		String jhDateTime = DateUtil.getDateStrByPattern(DateConstant.DATE14_, new Date());
		String planno = planProductionVo.getPlanno();
		planProductionVo.setPlanno(planno + jhDateTime);
		planProductionVo.setDatetime(dateTime);
		planProductionVo.setEditdatetime(dateTime);
		planProductionVo.setDeletestate(1);
		User user = (User) session.getAttribute("user");
		if (null != user) {
			planProductionVo.setEdituserid(user.getUserId());
			;
		}
		String planId = LDXXUtils.getUUID12();
		planProductionVo.setPlanid(planId);

		PlanProductionCount planProductionCount = new PlanProductionCount();
		planProductionCount.setDatetime(dateTime);
		planProductionCount.setId(LDXXUtils.getUUID12());
		planProductionCount.setPlanid(planId);
		planProductionCount.setPdneedincordec(planProductionVo.getPdneed());
		planProductionCount.setPdneedsourcestate(1);
		try {

			String siteId = LDXXUtils.getUUID12();
			planProductionVo.setSiteId(siteId);
			planProductionVo.setDeletestate(1);

			tanPuDiDianGuanLiDao.addTanPuDiDianVo(planProductionVo);

			int i = dao.addShengChanJiHuaVo(planProductionVo);

			jiHuaZengJianDao.addJiHuaZengJian(planProductionCount);

			String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
			jsonObject.put("resultMsg", daoMsg);
			jsonObject.put("daoMsg", i);
			jsonObject.put("obj", planProductionVo);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = jsonObject.toString();
		return result;
	}

	@Override
	public String updateShengChanJiHua(PlanProductionCollection planProductionCollection, HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		String dateTime = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		planProductionCollection.setEditdatetime(dateTime);
		planProductionCollection.setDeletestate(1);
		User user = (User) session.getAttribute("user");
		if (null != user) {
			planProductionCollection.setEdituserid(user.getUserId());
			;
		}
		try {
			PlanProductionCollection ppcOld = dao.getShengChanJiHuaById(planProductionCollection.getPlanid());
			BigDecimal oldPdNeed = ppcOld.getPdneed();
			BigDecimal newPdNeed = planProductionCollection.getPdneed();
			BigDecimal newJiHuaZengNum = newPdNeed.subtract(oldPdNeed);

			PlanProductionCount planProductionCount = new PlanProductionCount();

			int i = dao.updateShengChanJiHua(planProductionCollection);
			planProductionCount.setId(LDXXUtils.getUUID12());
			planProductionCount.setPdneedsourcestate(1);
			planProductionCount.setDatetime(dateTime);
			planProductionCount.setPlanid(planProductionCollection.getPlanid());
			planProductionCount.setPdneedincordec(newJiHuaZengNum);
			jiHuaZengJianDao.addJiHuaZengJian(planProductionCount);
			String chnsMsg = MsgFormatUtils.getMsgByResult(i, "修改");
			jsonObject.put("resultMsg", chnsMsg);
			jsonObject.put("daoMsg", i);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@Override
	public String updateShengChanJiHuaVo(PlanProductionVo planProductionVo, HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		String dateTime = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		planProductionVo.setEditdatetime(dateTime);
		planProductionVo.setDeletestate(1);
		User user = (User) session.getAttribute("user");
		if (null != user) {
			planProductionVo.setEdituserid(user.getUserId());
		}
		try {
			PlanProductionCollection ppcOld = dao.getShengChanJiHuaById(planProductionVo.getPlanid());
			BigDecimal oldPdNeed = ppcOld.getPdneed();
			BigDecimal newPdNeed = planProductionVo.getPdneed();
			BigDecimal newJiHuaZengNum = newPdNeed.subtract(oldPdNeed == null ? BigDecimal.valueOf(0) : oldPdNeed);

			PlanProductionCount planProductionCount = new PlanProductionCount();

			tanPuDiDianGuanLiDao.updateTanPuDiDianVo(planProductionVo);
			int i = dao.updateShengChanJiHuaVo(planProductionVo);


			planProductionCount.setId(LDXXUtils.getUUID12());
			planProductionCount.setPdneedsourcestate(1);
			planProductionCount.setDatetime(dateTime);
			planProductionCount.setPlanid(planProductionVo.getPlanid());
			planProductionCount.setPdneedincordec(newJiHuaZengNum);
			jiHuaZengJianDao.addJiHuaZengJian(planProductionCount);
			String chnsMsg = MsgFormatUtils.getMsgByResult(i, "修改");
			jsonObject.put("resultMsg", chnsMsg);
			jsonObject.put("daoMsg", i);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
}
