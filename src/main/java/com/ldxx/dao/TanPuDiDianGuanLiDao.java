package com.ldxx.dao;

import com.ldxx.bean.SiteConstruction;
import com.ldxx.vo.SiteConstructionVo;

import java.util.List;
import java.util.Map;

public interface  TanPuDiDianGuanLiDao {
	
	List<SiteConstruction> getDistinctTanPuDiDian();
	
	List<SiteConstructionVo> getAllTanPuDiDian();
	
	int addTanPuDiDian(SiteConstructionVo siteConstructionVo);
	
	int delTanPuDiDian(String id);
	
	int updateTanPuDiDian(SiteConstructionVo siteConstructionVo);
	
	List<SiteConstruction> getBiaoDuanByLuDuan(Map<String, String> map);

    List<SiteConstructionVo> getByLuDuanId(Map<String, String> map);

    List<SiteConstructionVo> getIDisroadName();
}
