package com.ldxx.service;

import java.util.List;

import com.ldxx.bean.SiteRoadMileage;

public interface SiteRoadMileageService {

	List<SiteRoadMileage> selectAllSiteRoadMileage();
	
	int updSiteRoadMileage(SiteRoadMileage srm);
	
	int delSiteRoadMileage(String id);
	
	int insertSiteRoadMileage(SiteRoadMileage srm);

}
