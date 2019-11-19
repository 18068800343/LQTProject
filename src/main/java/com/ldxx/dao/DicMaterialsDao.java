package com.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.DicMaterials;

public interface DicMaterialsDao {

	public List<DicMaterials> selectAllDicMaterials();
	
	public int addDicMaterials(@Param("dicMaterials")DicMaterials dicMaterials);
	
	public int deleteDicMaterials(String id);
	
	public int updateDicMaterials(@Param("dicMaterials")DicMaterials dicMaterials);
	
	public DicMaterials selectByName(String name);
	
}
