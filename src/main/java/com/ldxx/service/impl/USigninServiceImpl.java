package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.USignin;
import com.ldxx.dao.USigninDao;
import com.ldxx.service.USigninService;

@Service
@Transactional
public class USigninServiceImpl implements USigninService{

	@Autowired
	USigninDao usDao;
	@Override
	public List<USignin> selectAllUSignin() {
		List<USignin> list = usDao.selectAllUSignin();
		return list;
	}

}
