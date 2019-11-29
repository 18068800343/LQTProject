package com.ldxx.service.impl;

import com.ldxx.bean.SiteRoadMileage;
import com.ldxx.dao.SiteRoadMileageDao;
import com.ldxx.service.SiteRoadMileageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SiteRoadMileageServiceImpl implements SiteRoadMileageService {
	
	@Autowired
	private SiteRoadMileageDao dao;

	@Override
	public List<SiteRoadMileage> selectAllSiteRoadMileage(String luduanquanxian) {
		return dao.selectAllSiteRoadMileage(luduanquanxian);
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

	@Override
	public List<SiteRoadMileage> getByLuDuanId(String roadId) {
		return dao.getByLuDuanId(roadId);
	}

}
