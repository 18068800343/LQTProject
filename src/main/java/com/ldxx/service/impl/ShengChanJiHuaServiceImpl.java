package com.ldxx.service.impl;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.bean.PlanProductionCount;
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
import com.ldxx.weChat.shengchanjihuachongtutishi;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
    public int addShengChanJiHuaCurrent(String planId, String planNo, String editUserId, String time) {

        int k = dao.emptyShengChanJiHua();
        int i = 0;
        if (k >= 0) {
			PlanProductionCollectionVo planProductionCollectionVo = new PlanProductionCollectionVo();
			planProductionCollectionVo.setPlanid(planId);
			planProductionCollectionVo.setPlanno(planNo);
			planProductionCollectionVo.setEdituserid(editUserId);
			planProductionCollectionVo.setEditdatetime(time);
			i = dao.addShengChanJiHuaCurrent(planProductionCollectionVo);
		}
        return i;
    }

    @Override
    public String addShengChanJiHuaAndSiteConstruction(PlanProductionVo planProductionVo, HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		String dateTime = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		String jhDateTime = DateUtil.getDateStrByPattern(DateConstant.DATE14_, new Date());
		if (null != planProductionVo.getFinishTime() && !"".equals(planProductionVo.getFinishTime())) {
			jhDateTime = planProductionVo.getFinishTime().replace("-", "").replace(" ", "").replace(":", "");
		}
		String planno = planProductionVo.getPlanno();
		planProductionVo.setPlanno(jhDateTime + new Random().nextInt(1000));
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
			String finishTime = planProductionVo.getFinishTime();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制
			Date endTime = null;
			Date startime = null;
			try {
				endTime = format.parse(finishTime);
				startime = format.parse(finishTime);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if (endTime == null)
				return "";

			Calendar cal = Calendar.getInstance();
			cal.setTime(endTime);
			cal.add(Calendar.MINUTE, 30);// 24小时制
			endTime = cal.getTime();
			//System.out.println("after:" + format.format(endTime));  //显示更新后的日期
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(startime);
			cal2.add(Calendar.MINUTE, -30);// 24小时制
			startime = cal2.getTime();
			//System.out.println("after:" + format.format(startime));  //显示更新后的日期

			String end = format.format(endTime);
			String start = format.format(startime);
			List<PlanProductionCollectionVo> countList= dao.getCountByfinishTime(start,end);

			if(countList!=null&&countList.size()>0){
				shengchanjihuachongtutishi.chongtutishi();
			}
			String siteId = LDXXUtils.getUUID12();
			planProductionVo.setSiteId(siteId);
			planProductionVo.setDeletestate(1);

			tanPuDiDianGuanLiDao.addTanPuDiDianVo(planProductionVo);

			int i = dao.addShengChanJiHuaVo(planProductionVo);

			jiHuaZengJianDao.addJiHuaZengJian(planProductionCount);
			String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
			jsonObject.put("resultMsg", daoMsg);
			jsonObject.put("daoMsg", i);
			jsonObject.put("conflictMsg", countList);
			jsonObject.put("obj", planProductionVo);

		} catch (JSONException  e) {
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

			String finishTime = planProductionVo.getFinishTime();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制
			Date endTime = null;
			Date startime = null;
			try {
				endTime = format.parse(finishTime);
				startime = format.parse(finishTime);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if (endTime == null)
				return "";

			Calendar cal = Calendar.getInstance();
			cal.setTime(endTime);
			cal.add(Calendar.MINUTE, 30);// 24小时制
			endTime = cal.getTime();
			System.out.println("after:" + format.format(endTime));  //显示更新后的日期
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(startime);
			cal2.add(Calendar.MINUTE, -30);// 24小时制
			startime = cal2.getTime();
			System.out.println("after:" + format.format(startime));  //显示更新后的日期

			String end = format.format(endTime);
			String start = format.format(startime);
			List<PlanProductionCollectionVo> countList= dao.xggetCountByfinishTime(start,end,planProductionVo.getPlanid());

			if(countList!=null&&countList.size()>0){
				shengchanjihuachongtutishi.chongtutishi();
			}
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
			jsonObject.put("conflictMsg", countList);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
}
