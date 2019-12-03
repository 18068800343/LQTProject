package com.ldxx.service.impl;

import com.ldxx.bean.SiteRoadSpend;
import com.ldxx.dao.SiteRoadSpendDao;
import com.ldxx.service.SiteRoadSpendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SiteRoadSpendServiceImpl implements SiteRoadSpendService {

    @Autowired
    private SiteRoadSpendDao sdao;

    @Override
    public List<SiteRoadSpend> selectAllSiteRoadSpend(String luduanquanxian) {
        return sdao.selectAllSiteRoadSpend(luduanquanxian);
    }

    @Override
    public int updSiteRoadSpend(SiteRoadSpend srs) {
        return sdao.updSiteRoadSpend(srs);
    }

    @Override
    public int delSiteRoadSpend(String id) {
        return sdao.delSiteRoadSpend(id);
    }

    @Override
    public int insertSiteRoadSpend(SiteRoadSpend srs) {
        return sdao.insertSiteRoadSpend(srs);
    }

    @Override
    public List<SiteRoadSpend> getByLuDuanId(String roadId) {
        return sdao.getByLuDuanId(roadId);
    }
}
