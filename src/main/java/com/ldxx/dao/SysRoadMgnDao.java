package com.ldxx.dao;

import com.ldxx.bean.SysRoadMgn;
import com.ldxx.bean.SysRoadMgnLowcase;
import com.ldxx.vo.SysRoadMgnVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoadMgnDao {
	
	public int addSysRoadMgn(@Param("sysRoadMgn")SysRoadMgn sysRoadMgn);
	
	public int updateSysRoadMgnById(@Param("sysRoadMgn")SysRoadMgn sysRoadMgn);
	
	public List<SysRoadMgn> getAllSysRoadMgn(String luduanquanxian);


	public List<SysRoadMgnVo> getAllSysRoadMgnVoHomePage(String luduanquanxian);

	public List<SysRoadMgnLowcase> getAllSysRoadMgnLowcase();

	public int delSysRoadMgn(@Param("id") String id);
	
	public SysRoadMgn getByIdSysRoadMgn(@Param("id") String id);

	SysRoadMgn selectSysRoadMgnById(String luduan);

	public int finishRoad(String id);

    List<SysRoadMgnLowcase> getAllSysRoadMgn2(@Param("luduanquanxian")String luduanquanxian);
}
