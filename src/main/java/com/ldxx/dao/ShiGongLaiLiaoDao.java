package com.ldxx.dao;

import com.ldxx.vo.SiteFieldMaterialMgtVo;

import java.util.List;

public interface  ShiGongLaiLiaoDao {
	
	
	List<SiteFieldMaterialMgtVo> getAllShiGongLaiLiao(String luduanquanxian);
	
	int addShiGongLaiLiao(SiteFieldMaterialMgtVo siteFieldMaterialMgtVo);
	
	int delShiGongLaiLiao(String id);
	
	int updateShiGongLaiLiao(SiteFieldMaterialMgtVo siteFieldMaterialMgtVo);

	List<SiteFieldMaterialMgtVo> getByLuDuanId(String roadId);

}
