package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.bean.SiteRoadMileage;
import com.ldxx.bean.User;
import com.ldxx.dao.SiteRoadMileageDao;
import com.ldxx.service.SiteRoadMileageService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.TanPuLiChengVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 摊铺里程
 * @author hp
 *
 */

@RestController
@RequestMapping("SiteRoadMileage")
public class SiteRoadMileageController {
	
	@Autowired
	private SiteRoadMileageService service;

	@Resource
	private SiteRoadMileageDao dao;

	private Map<String,Object> map=new HashMap<>();
	
	@RequestMapping("/selectAllSiteRoadMileage")
	public List<SiteRoadMileage> selectAllSiteRoadMileage(HttpSession session,String  roadquanxain){
		String luduanquanxian="";
		if(roadquanxain!=null){
			luduanquanxian=roadquanxain;
		}else{
			User user = (User) session.getAttribute("user");
			luduanquanxian = user.getLuduanquanxian();
		}
		return service.selectAllSiteRoadMileage(luduanquanxian);
	}

	@RequestMapping("/getTanPuLiChengVoListByTime")
	@ResponseBody
	public TanPuLiChengVo getTanPuLiChengVoListByTime(String beginTime, String endTime,String roadId){
		List<SiteRoadMileage> list = dao.getTanPuLiChengVoListByTime(beginTime,endTime,roadId);
		TanPuLiChengVo tanPuLiChengVo = new TanPuLiChengVo();
		tanPuLiChengVo  = tanPuLiChengVo.getTanPuLiChengVoByPeiBiVoList(list);
		return tanPuLiChengVo;
	}

	@RequestMapping("/updSiteRoadMileage")
	public Map<String,Object> updSiteRoadMileage(@RequestBody SiteRoadMileage srm ,HttpSession session){
		JSONObject jsonObject = new JSONObject();
        srm.setEditDatetime2(GetThisTimeUtils.getDateTime());
        User user = (User) session.getAttribute("user");
		if(null!=user) {
			srm.setEditUserId2(user.getUserId());
			srm.setEditDatetime2(GetThisTimeUtils.getDateTime());
		}
		int i= service.updSiteRoadMileage(srm);
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "修改");
		map.put("resultMsg",daoMsg);
		map.put("daoMsg",i);
		map.put("obj",srm);
		return map;
	}
	
	@RequestMapping("/delSiteRoadMileage")
	public int delSiteRoadMileage(String id){
		int i= service.delSiteRoadMileage(id);
		return i;
	}
	
	@RequestMapping("/insertSiteRoadMileage")
	public Map<String,Object> insertSiteRoadMileage(@RequestBody SiteRoadMileage srm,HttpSession session){
		JSONObject jsonObject = new JSONObject();
		srm.setId(LDXXUtils.getUUID12());
		srm.setEditDatetime2(GetThisTimeUtils.getDateTime());
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			srm.setEditUserId2(user.getUserId());
			srm.setEditDatetime2(GetThisTimeUtils.getDateTime());
		}
		int i= service.insertSiteRoadMileage(srm);
		String daoMsg = MsgFormatUtils.getMsgByResult(i, "新增");
		map.put("resultMsg",daoMsg);
		map.put("daoMsg",i);
		map.put("obj",srm);
		return map;
	}

	/**
	 * 通过路段roadId获取信息
	 * @param roadId
	 * @return
	 */
	@RequestMapping("/getByLuDuanId")
	public List<SiteRoadMileage> getByLuDuanId(String roadId) {
		return service.getByLuDuanId(roadId);
	}

}
