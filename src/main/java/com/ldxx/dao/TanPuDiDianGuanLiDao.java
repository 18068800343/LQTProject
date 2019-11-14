package com.ldxx.dao;

import java.util.List;
import java.util.Map;

import com.ldxx.bean.SiteConstruction;
import com.ldxx.vo.SiteConstructionVo;

public interface  TanPuDiDianGuanLiDao {
	
	List<SiteConstruction> getDistinctTanPuDiDian();
	
	List<SiteConstructionVo> getAllTanPuDiDian();
	
	int addTanPuDiDian(SiteConstructionVo siteConstructionVo);
	
	int delTanPuDiDian(String id);
	
	int updateTanPuDiDian(SiteConstructionVo siteConstructionVo);
	
	List<SiteConstruction> getBiaoDuanByLuDuan(Map<String, String> map);

    List<SiteConstruction> getByLuDuanId(Map<String, String> map);

    List<SiteConstructionVo> getIDisroadName();
}
