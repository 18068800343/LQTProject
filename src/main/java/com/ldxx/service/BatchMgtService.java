package com.ldxx.service;

import java.util.List;
import com.ldxx.bean.BatchMgt;
import com.ldxx.vo.BatchMgtVo;

public interface BatchMgtService {
	
	List<BatchMgtVo> getAllBatchMgt();
	
	BatchMgt getBatchMgtById(String id);
	
	int updBatchMgt(BatchMgt bm);
	
	int delBatchMgt(String id);

	int insertBatchMgt(BatchMgt bm);
	
	BatchMgt getBatchMgtByPlate(String licencePlate);

}
