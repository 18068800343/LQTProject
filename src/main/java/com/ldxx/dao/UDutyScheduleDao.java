package com.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.UDutySchedule;

public interface UDutyScheduleDao {
	
	List<UDutySchedule> getAllUDutySchedule();
	
	int updUDutySchedule(@Param("us")UDutySchedule us);
	
	int delUDutySchedule(@Param("id")String id);
	
	int insertUDutySchedule(@Param("us")UDutySchedule us);

}
