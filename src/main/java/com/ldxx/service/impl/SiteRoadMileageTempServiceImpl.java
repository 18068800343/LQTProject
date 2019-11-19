package com.ldxx.service.impl;

import com.ldxx.bean.SiteRoadMileageTemp;
import com.ldxx.dao.SiteRoadMileageTempDao;
import com.ldxx.service.SiteRoadMileageTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SiteRoadMileageTempServiceImpl implements SiteRoadMileageTempService {

    @Autowired
    private SiteRoadMileageTempDao dao;

    @Override
    public List<SiteRoadMileageTemp> getAllSiteRoadMileageTemp() {
        return dao.getAllSiteRoadMileageTemp();
    }

    @Override
    public int updSiteRoadMileageTemp(SiteRoadMileageTemp srm) {
        return dao.updSiteRoadMileageTemp(srm);
    }

    @Override
    public int delSiteRoadMileageTemp(String id) {
        return dao.delSiteRoadMileageTemp(id);
    }

    @Override
    public int insertSiteRoadMileageTemp(SiteRoadMileageTemp srm) {
        return dao.insertSiteRoadMileageTemp(srm);
    }
}
