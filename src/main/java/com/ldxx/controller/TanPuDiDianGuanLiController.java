package com.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ldxx.bean.SiteConstruction;
import com.ldxx.service.TanPuDiDianGuanLiService;

@Controller
@RequestMapping("/TanPuDiDianGuanLi")
public class TanPuDiDianGuanLiController {
	
	@Autowired
	private TanPuDiDianGuanLiService service;
	
	@RequestMapping("/getDistinctTanPuDiDian")
	@ResponseBody
    public List<SiteConstruction> getDistinctTanPuDiDian() {
        return service.getDistinctTanPuDiDian();
    }
	
	@RequestMapping("/getBiaoDuanByLuDuan")
	@ResponseBody
	public List<SiteConstruction> getBiaoDuanByLuDuan(String roadno) {
		Map<String, String> map = new HashMap<>();
		map.put("roadno", roadno);
		return service.getBiaoDuanByLuDuan(map);
	}

}
