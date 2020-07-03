package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.PlanConstructionDeviation;
import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.bean.SiteConstruction;
import com.ldxx.bean.User;
import com.ldxx.dao.ShengChanJiHuaDao;
import com.ldxx.service.ShengChanJiHuaService;
import com.ldxx.util.DateUtil;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ShengChanJiHua")
public class ShengChanJiHuaController {

	@Autowired
	private ShengChanJiHuaService service;
	@Resource
	private ShengChanJiHuaDao dao;

	@RequestMapping("/getAllShengChanJiHua")
	@ResponseBody
	public List<PlanProductionCollectionVo> getAllShengChanJiHua() {
		return service.getShengChanJiHuaListByCondition();
	}

	@RequestMapping("/getPianChaById")
	@ResponseBody
	public PlanConstructionDeviationVo getPianChaById(String id) {
		return dao.getPianChaById(id);
	}

	@RequestMapping("/linkShiGongPianCha")
	@ResponseBody
	public int linkShiGongPianCha(String planid, String pianchaid) {
		int i = dao.linkShiGongPianCha(planid, pianchaid);

		return i;
	}

	@RequestMapping("/getAllShiGongPianCha")
	@ResponseBody
	public List<PlanConstructionDeviationVo> getAllShiGongPianCha() {
		return dao.getAllShiGongPianCha();
	}

	@RequestMapping("/delShengChanJiHuaById")
	@ResponseBody
	public int delShengChanJiHuaById(String planid) {
		return dao.delShengChanJiHuaById(planid);
	}

	@RequestMapping("/delShiGongPianChaById")
	@ResponseBody
	public int delShiGongPianChaById(String id) {
		return dao.delShiGongPianChaById(id);
	}

	@RequestMapping("/addShiGongPianCha")
	@ResponseBody
	public String addShiGongPianCha(@RequestBody PlanConstructionDeviation planConstructionDeviation) {
		planConstructionDeviation.setDeletestate(1);
		String dateTime = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		planConstructionDeviation.setDatetime(dateTime);
		planConstructionDeviation.setId(LDXXUtils.getUUID12());
		JSONObject jsonObject = new JSONObject();
		int i = dao.addShiGongPianCha(planConstructionDeviation);
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",planConstructionDeviation);
		return jsonObject.toString();
	}

	@RequestMapping("/updateShiGongPianCha")
	@ResponseBody
	public String updateShiGongPianCha(@RequestBody PlanConstructionDeviation planConstructionDeviation) {
		planConstructionDeviation.setDeletestate(1);
		String dateTime = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		planConstructionDeviation.setDatetime(dateTime);
		JSONObject jsonObject = new JSONObject();
		int i = dao.updateShiGongPianCha(planConstructionDeviation);
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "修改");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj", planConstructionDeviation);
		return jsonObject.toString();
	}

	@RequestMapping("/addShengChanJiHua")
	@ResponseBody
	public String addShengChanJiHua(@RequestBody PlanProductionVo planProductionVo, HttpSession session) {


		String result = service.addShengChanJiHuaAndSiteConstruction(planProductionVo, session);

		return result;
	}

	@RequestMapping("/addShengChanJiHuaCurrent")
	@ResponseBody
	public int addShengChanJiHuaCurrent(String planId, String planNo, HttpSession session) {

		String nowDate = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		User user = (User) session.getAttribute("user");
		String userId = "";
		if (null != user) {
			userId = user.getUserId();
		}
		int result = service.addShengChanJiHuaCurrent(planId, planNo, userId, nowDate);

		return result;
	}

	@RequestMapping("/getShengChanJiHuaNow")
	@ResponseBody
	public PlanProductionCollectionVo getShengChanJiHuaNow() {
		return dao.getShengChanJiHuaNow();
	}

	@RequestMapping("/getShengChanJiHuaToday")
	@ResponseBody
	public List<PlanProductionCollectionVo> getShengChanJiHuaToday() {
		String time = DateUtil.getDateStrByPattern(DateConstant.DATE10, new Date()) + "%";
		return dao.getShengChanJiHuaListByTime(time);
	}

	@RequestMapping("/updateShengChanJiHua")
	@ResponseBody
	public String updateShengChanJiHua(@RequestBody PlanProductionVo planProductionVo, HttpSession session) {

		String result = service.updateShengChanJiHuaVo(planProductionVo, session);

		return result;
	}

}
