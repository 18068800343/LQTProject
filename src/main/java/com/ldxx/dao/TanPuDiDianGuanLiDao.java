package com.ldxx.dao;

import java.util.List;
import java.util.Map;

import com.ldxx.bean.SiteConstruction;

public interface  TanPuDiDianGuanLiDao {
	
	List<SiteConstruction> getDistinctTanPuDiDian();
	
	List<SiteConstruction> getBiaoDuanByLuDuan(Map<String, String> map);
}
