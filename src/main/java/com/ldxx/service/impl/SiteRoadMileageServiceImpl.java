package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.SiteRoadMileage;
import com.ldxx.dao.SiteRoadMileageDao;
import com.ldxx.service.SiteRoadMileageService;

@Service
@Transactional
public class SiteRoadMileageServiceImpl implements SiteRoadMileageService {
	
	@Autowired
	private SiteRoadMileageDao dao;

	@Override
	public List<SiteRoadMileage> selectAllSiteRoadMileage() {
		return dao.selectAllSiteRoadMileage();
	}

	@Override
	public int updSiteRoadMileage(SiteRoadMileage srm) {
		return dao.updSiteRoadMileage(srm);
	}

	@Override
	public int delSiteRoadMileage(String id) {
		return dao.delSiteRoadMileage(id);
	}

	@Override
	public int insertSiteRoadMileage(SiteRoadMileage srm) {
		return dao.insertSiteRoadMileage(srm);
	}

}
