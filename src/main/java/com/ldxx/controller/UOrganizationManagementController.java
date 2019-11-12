package com.ldxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldxx.bean.UOrganizationManagement;
import com.ldxx.dao.UOrganizationManagementDao;

/**
 * 部门
 * @author hp
 *
 */
@Controller
@RequestMapping("UOrganizationManagement")
public class UOrganizationManagementController {
	
	@Autowired
	private UOrganizationManagementDao dao;
	
	@RequestMapping("/getAllUOrganizationManagement")
	@ResponseBody
	public List<UOrganizationManagement> getAllUOrganizationManagement(){
		return dao.getAllUOrganizationManagement();
	}

}
