package com.ldxx.service;

import java.util.List;
import com.ldxx.bean.WhIncomingMaterial;

public interface WhIncomingMaterialService {
	
	List<WhIncomingMaterial> getAllWhIncomingMaterial();
	
	WhIncomingMaterial getWhIncomingMaterialById(String id);
	
	int updWhIncomingMaterialById(WhIncomingMaterial wm);
	
	int delWhIncomingMaterialById(String id);
	
	int insertWhIncomingMaterial(WhIncomingMaterial wm);

}
