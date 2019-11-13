package com.ldxx.service;

import java.util.List;

import com.ldxx.bean.UDutySchedule;

public interface UDutyScheduleService {
	
	List<UDutySchedule> getAllUDutySchedule();
	
	int updUDutySchedule(UDutySchedule us);
	
	int delUDutySchedule(String id);
	
	int insertUDutySchedule(UDutySchedule us);

}
