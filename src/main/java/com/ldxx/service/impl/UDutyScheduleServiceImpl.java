package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldxx.bean.UDutySchedule;
import com.ldxx.dao.UDutyScheduleDao;
import com.ldxx.service.UDutyScheduleService;

@Service
public class UDutyScheduleServiceImpl implements UDutyScheduleService {

	@Autowired
	private UDutyScheduleDao dao;
	
	@Override
	public List<UDutySchedule> getAllUDutySchedule() {
		// TODO Auto-generated method stub
		return dao.getAllUDutySchedule();
	}

	@Override
	public int updUDutySchedule(UDutySchedule us) {
		// TODO Auto-generated method stub
		return dao.updUDutySchedule(us);
	}

	@Override
	public int delUDutySchedule(String id) {
		// TODO Auto-generated method stub
		return dao.delUDutySchedule(id);
	}

	@Override
	public int insertUDutySchedule(UDutySchedule us) {
		// TODO Auto-generated method stub
		return dao.insertUDutySchedule(us);
	}

}
