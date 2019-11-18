package com.ldxx.dao;

import com.ldxx.vo.SiteCompactionNumVo;

import java.util.List;

public interface NianYaCiShuDao {


	List<SiteCompactionNumVo> getAllNianYaCiShu();


	int addNianYaCiShu(SiteCompactionNumVo siteCompactionNumVo);

	int delNianYaCiShu(String id);

	int updateNianYaCiShu(SiteCompactionNumVo siteCompactionNumVo);

}
