package com.ldxx.service;

import java.util.List;
import com.ldxx.bean.BatchMgt;

public interface BatchMgtService {
	
	List<BatchMgt> getAllBatchMgt();
	
	BatchMgt getBatchMgtById(String id);
	
	int updBatchMgt(BatchMgt bm);
	
	int delBatchMgt(String id);

	int insertBatchMgt(BatchMgt bm);
	
	BatchMgt getBatchMgtByPlate(String licencePlate);

}
