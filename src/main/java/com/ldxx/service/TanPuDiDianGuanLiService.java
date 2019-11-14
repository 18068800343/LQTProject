package com.ldxx.service;

import java.util.List;
import java.util.Map;

import com.ldxx.bean.SiteConstruction;

public interface TanPuDiDianGuanLiService {
	
	List<SiteConstruction> getDistinctTanPuDiDian();
	
	List<SiteConstruction> getBiaoDuanByLuDuan(Map<String, String> map);

    List<SiteConstruction> getByLuDuanId(Map<String, String> map);
}
