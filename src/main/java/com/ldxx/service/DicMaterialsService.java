package com.ldxx.service;

import java.util.List;

import com.ldxx.bean.DicMaterials;

public interface DicMaterialsService {
	
	public List<DicMaterials> selectAllDicMaterials();
	
	public int addDicMaterials(DicMaterials dicMaterials);
	
	public int deleteDicMaterials(String id);
	
	public int updateDicMaterials(DicMaterials dicMaterials);
	
}
