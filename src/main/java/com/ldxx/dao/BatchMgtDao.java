package com.ldxx.dao;

import com.ldxx.bean.BatchMgt;
import com.ldxx.vo.BatchMgtVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BatchMgtDao {
	
	List<BatchMgtVo> getAllBatchMgt();
	
	BatchMgt getBatchMgtById(@Param("id")String id);
	
	BatchMgtVo getBatchMgtVoById(@Param("id")String id);
	
	int updBatchMgt(@Param("bm")BatchMgt bm);
	
	int delBatchMgt(@Param("id")String id);

	int insertBatchMgt(@Param("bm")BatchMgt bm);
	
	BatchMgt getBatchMgtByPlate(@Param("licencePlate")String licencePlate);

	List<BatchMgtVo> getBatchToday(@Param("batch")String batch,@Param("licencePlate")String licencePlate);

	List<BatchMgtVo> getBatchBybatch(@Param("batch")String batch,@Param("licencePlate")String licencePlate);
}
