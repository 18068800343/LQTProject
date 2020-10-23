package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ldxx.bean.User;
import com.ldxx.dao.WhWarehouseCountDao;
import com.ldxx.vo.WhCangChuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ldxx.bean.WhWarehouseCount;
import com.ldxx.service.WhWarehouseCountService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 仓储管理
 * @author hp
 *
 */

@Controller
@RequestMapping("WhWarehouseCount")
public class WhWarehouseCountController {

	@Autowired
	private WhWarehouseCountService service;

	@Resource
	private WhWarehouseCountDao dao;

	private Map<String, Object> map = new HashMap<>();

	@RequestMapping("/getAllWhWarehouseCount")
	@ResponseBody
	public List<WhWarehouseCount> getAllWhWarehouseCount() {
		return service.getAllWhWarehouseCount();
	}

	@RequestMapping("/initCangChuGuanLi")
	@ResponseBody
	public List<WhCangChuVo> initCangChuGuanLi() {
		List list = dao.initCangChuGuanLi();
		return list;
	}

	@RequestMapping("/getWhWarehouseCountById")
	@ResponseBody
	public WhWarehouseCount getWhWarehouseCountById(String id) {
		return service.getWhWarehouseCountById(id);
	}
	
	@RequestMapping("/updWhWarehouseCountById")
	@ResponseBody
	public Map<String,Object> updWhWarehouseCountById(WhWarehouseCount wwc, HttpSession session) {
		wwc.setEditDatetime2(GetThisTimeUtils.getDateTime());
		User user = (User) session.getAttribute("user");
		if(null!=user) {
            wwc.setEditUserId2(user.getUserId());
            ;
            wwc.setuName(user.getuName());
            ;
        }
		int i = service.updWhWarehouseCountById(wwc);
		map.put("result", i);
		map.put("WhWarehouseCount", wwc);
		return map;
	}

	@RequestMapping("/delWhWarehouseCountById")
	@ResponseBody
	public int delWhWarehouseCountById(String id) {
		return service.delWhWarehouseCountById(id);
	}

	@RequestMapping("/getLiaoCangPanDian")
	@ResponseBody
	public List<Map> getLiaoCangPanDian() {
		List<Map> map = dao.getLiaoCangPanDian();
		for (Map dom : map) {
			String dayTimeOut = (String) dom.get("dayTimeOut");
			//获取本日最后一个生产时间 格式 yyyy-MM-dd HH:mm:ss
			String endTime = dao.getProductEndTime(dayTimeOut.trim());
			//获取本日最新一个盘点时间 格式 yyyy-MM-dd HH:mm:ss
			String startTime = dao.getLaiLiaoTime();
			Double yongliao = 0.0;
			Double lailiao = 0.0;
			yongliao = dao.getYongLiaoWeightByTime(startTime, endTime);
			lailiao = dao.getLaiLiaoWeightByTime(startTime.replace(":", "-"), endTime.replace(":", "-"));
			if (yongliao == null) {
				yongliao = 0.0;
			}
			if (lailiao == null) {
				lailiao = 0.0;
			}
			Double yuliao = lailiao - yongliao;
			yuliao = Double.valueOf(String.format("%.2f", yuliao));
			dom.put("dayWeightCha", yuliao);
		}
		return map;

	}

	@RequestMapping("/insertWhWarehouseCount")
	@ResponseBody
	public Map<String, Object> insertWhWarehouseCount(WhWarehouseCount wwc, HttpSession session) {
		wwc.setId(LDXXUtils.getUUID12());
		wwc.setEditDatetime2(GetThisTimeUtils.getDateTime());
		User user = (User) session.getAttribute("user");
		if (null != user) {
            wwc.setEditUserId2(user.getUserId());
            wwc.setuName(user.getuName());
            ;
        }

		int i= service.insertWhWarehouseCount(wwc);
		map.put("result",i);
		map.put("WhWarehouseCount",wwc);
		return map;
	}

}
