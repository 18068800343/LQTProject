package com.ldxx.service;

import com.ldxx.bean.SiteRoadMileage;

import java.util.List;

public interface SiteRoadMileageService {

	List<SiteRoadMileage> selectAllSiteRoadMileage(String luduanquanxian);
	
	int updSiteRoadMileage(SiteRoadMileage srm);
	
	int delSiteRoadMileage(String id);
	
	int insertSiteRoadMileage(SiteRoadMileage srm);

	List<SiteRoadMileage> getByLuDuanId(String roadId);


}
