package com.ldxx.dao;

import com.ldxx.vo.SiteCompactionNumVo;

import java.util.List;

public interface NianYaCiShuDao {


	List<SiteCompactionNumVo> getAllNianYaCiShu(String luduanquanxian);


	int addNianYaCiShu(SiteCompactionNumVo siteCompactionNumVo);

	int delNianYaCiShu(String id);

	int updateNianYaCiShu(SiteCompactionNumVo siteCompactionNumVo);

    List<SiteCompactionNumVo> getByLuDuanId(String roadId);
}
