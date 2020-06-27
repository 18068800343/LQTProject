package com.ldxx.controller;

import java.util.List;

import com.ldxx.dao.USigninDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.USignin;
import com.ldxx.service.USigninService;

import javax.annotation.Resource;

@Controller
@RequestMapping("USignin")
public class USigninController {
	@Autowired
	USigninService usService;

	@Resource
	USigninDao uSigninDao;

	@RequestMapping("/selectAllUSignin")
	@ResponseBody
	public List<USignin> selectAllUSignin(String state, String beginTime, String endTime) {
		List<USignin> usList = uSigninDao.selectAllUSigninByState(state, beginTime, endTime);
		return usList;
	}
}
