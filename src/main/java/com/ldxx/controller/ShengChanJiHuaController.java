package com.ldxx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.Constant.DateConstant;
import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.bean.User;
import com.ldxx.service.ShengChanJiHuaService;
import com.ldxx.service.UserService;
import com.ldxx.util.DateUtil;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.PlanProductionCollectionVo;

@Controller
@RequestMapping("/ShengChanJiHua")
public class ShengChanJiHuaController {
	
	@Autowired
	private ShengChanJiHuaService service;
	
	@RequestMapping("/getAllShengChanJiHua")
	@ResponseBody
    public List<PlanProductionCollectionVo> getAllShengChanJiHua() {
        return service.getShengChanJiHuaListByCondition();
    }
	
	@RequestMapping("/addShengChanJiHua")
	@ResponseBody
	public JSONObject addShengChanJiHua(@RequestBody PlanProductionCollection planProductionCollection) {
		
		JSONObject jsonObject = new JSONObject();
		String dateTime = DateUtil.getDateStrByPattern(DateConstant.DATE19, new Date());
		planProductionCollection.setDatetime(dateTime);
		try {
			int i = service.addShengChanJiHua(planProductionCollection);
			String daoMsg = MsgFormatUtils.getMsgByResult(i, "插入");
			jsonObject.put("resultMsg",daoMsg);
			jsonObject.put("daoMsg",i);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
		
	}

}
