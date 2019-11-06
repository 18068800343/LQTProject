package com.ldxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.PlanProductionCollection;
import com.ldxx.bean.User;
import com.ldxx.service.ShengChanJiHuaService;
import com.ldxx.service.UserService;
import com.ldxx.util.LDXXUtils;
import com.ldxx.vo.PlanProductionCollectionVo;

@Controller
@RequestMapping("/ShengChanJiHua")
public class ShengChanJiHuaController {
	
	@Autowired
	private ShengChanJiHuaService service;
	
	@RequestMapping("/getAllShengChanJiHua")
	@ResponseBody
    public List<PlanProductionCollectionVo> addUser() {
        return service.getShengChanJiHuaListByCondition();
    }

}
