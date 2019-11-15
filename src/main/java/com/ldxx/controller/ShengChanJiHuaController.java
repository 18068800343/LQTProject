package com.ldxx.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.PlanConstructionDeviation;
import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.bean.User;
import com.ldxx.dao.ShengChanJiHuaDao;
import com.ldxx.service.ShengChanJiHuaService;
import com.ldxx.util.DateUtil;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.PlanConstructionDeviationVo;
import com.ldxx.vo.PlanProductionCollectionVo;

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
 		int i = dao.linkShiGongPianCha(planid,pianchaid);

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
		jsonObject.put("obj",planConstructionDeviation);
		return jsonObject.toString();
	}
	
	@RequestMapping("/addShengChanJiHua")
	@ResponseBody
	public String addShengChanJiHua(@RequestBody PlanProductionCollection planProductionCollection,HttpSession session) {
		
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
		planProductionCollection.setPlanid(LDXXUtils.getUUID12());
		try {
			int i = service.addShengChanJiHua(planProductionCollection);
			String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
			jsonObject.put("resultMsg",daoMsg);
			jsonObject.put("daoMsg",i);
			jsonObject.put("obj",planProductionCollection);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = jsonObject.toString();
		return result;
		
	}
	
	@RequestMapping("/updateShengChanJiHua")
	@ResponseBody
	public String updateShengChanJiHua(@RequestBody PlanProductionCollection planProductionCollection,HttpSession session) {
		
		JSONObject jsonObject = new JSONObject();
		String dateTime = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		planProductionCollection.setEditdatetime(dateTime);
		planProductionCollection.setDeletestate(1);
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			planProductionCollection.setEdituserid(user.getUserId());;
		}
		try {
			int i = dao.updateShengChanJiHua(planProductionCollection);
			String chnsMsg = MsgFormatUtils.getMsgByResult(i, "修改");
			jsonObject.put("resultMsg",chnsMsg);
			jsonObject.put("daoMsg",i);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
		
	}

}
