package com.ldxx.service;

import com.ldxx.bean.SiteRoadSpend;

import java.util.List;

public interface SiteRoadSpendService {

    List<SiteRoadSpend> selectAllSiteRoadSpend(String luduanquanxian);

    int updSiteRoadSpend( SiteRoadSpend srs);

    int delSiteRoadSpend(String id);

    int insertSiteRoadSpend(SiteRoadSpend srs);

    List<SiteRoadSpend> getByLuDuanId(String roadId);
}
