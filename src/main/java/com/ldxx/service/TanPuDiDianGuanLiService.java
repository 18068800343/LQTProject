package com.ldxx.service;

import com.ldxx.bean.SiteConstruction;
import com.ldxx.vo.SiteConstructionVo;

import java.util.List;
import java.util.Map;

public interface TanPuDiDianGuanLiService {
	
	List<SiteConstruction> getDistinctTanPuDiDian();
	
	List<SiteConstruction> getBiaoDuanByLuDuan(Map<String, String> map);

    List<SiteConstructionVo> getByLuDuanId(Map<String, String> map);
}
