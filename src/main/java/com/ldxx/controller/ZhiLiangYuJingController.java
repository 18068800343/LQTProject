package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.User;
import com.ldxx.dao.StateRoleLinkDao;
import com.ldxx.dao.UserDao;
import com.ldxx.dao.ZhiLiangYuJingDao;
import com.ldxx.service.ZhiLiangYuJingService;
import com.ldxx.util.DateUtil;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.PlanProductionWarningVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/ZhiLiangYuJingController")
public class ZhiLiangYuJingController {


	@Resource
	private ZhiLiangYuJingDao dao;
	@Resource
	private StateRoleLinkDao roleLinkDao;
	@Resource
	private ZhiLiangYuJingService service;
	@Autowired
	private UserDao udao;

	@RequestMapping("/getAllZhiLiangYuJing")
	@ResponseBody
	public Map getAllZhiLiangYuJing(HttpSession session, String userId) {
		String uId;
		User user;
		if (userId == null || userId == "") {
			user = (User) session.getAttribute("user");
			uId = user.getUserId();
		} else {
			uId = userId;
			user = udao.selectUserById(uId);
		}


		Map map = new HashMap();

		map.put("list", dao.getAllZhiLiangYuJing());
		Optional.ofNullable(user)
				.ifPresent(u -> {

					List roleList = roleLinkDao.getStateRoleByUserId(uId);
					map.put("user", u);
					map.put("stateList", roleList);
				});

		return map;
	}

	@RequestMapping("/submitYuJing")
	@ResponseBody
	public int submitYuJing(@RequestBody PlanProductionWarningVo planProductionWarningVo,HttpSession session) {
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
		 int i =  dao.updateZhiLiangYuJingStatus(planProductionWarningVo);
         return i;
	}

	@RequestMapping("/feiliao")
	@ResponseBody
	public int feiliao(@RequestBody PlanProductionWarningVo planProductionWarningVo,HttpSession session) {
		return service.updateZhiLiangYuJingStatusService(planProductionWarningVo,session);
	}

	@RequestMapping("/addZhiLiangYuJing")
	@ResponseBody
	public String addZhiLiangYuJing(@RequestBody PlanProductionWarningVo planProductionWarningVo,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		planProductionWarningVo.setId(LDXXUtils.getUUID12());
		planProductionWarningVo.setDeletestate(1);
		String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		planProductionWarningVo.setDatetime(nowDateStr);
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			planProductionWarningVo.setSenduserid(user.getUserId());
			planProductionWarningVo.setUname(user.getuName());
		}
		int i = 0;
		try {
			i = dao.addZhiLiangYuJing(planProductionWarningVo);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
		}
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",planProductionWarningVo);
		return jsonObject.toString();
	}

	@RequestMapping("/updateZhiLiangYuJing")
	@ResponseBody
	public String updateZhiLiangYuJing(@RequestBody PlanProductionWarningVo planProductionWarningVo,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		String nowDateStr = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		planProductionWarningVo.setDatetime(nowDateStr);
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			planProductionWarningVo.setUname(user.getuName());
		}
		int i = 0;
		try {
			i = dao.updateZhiLiangYuJing(planProductionWarningVo);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("errMsg","数据库插入出错,请检查经纬度输入格式");
		}
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "修改");
		jsonObject.put("resultMsg",daoMsg);
		jsonObject.put("daoMsg",i);
		jsonObject.put("obj",planProductionWarningVo);
		return jsonObject.toString();
	}

}
