package com.ldxx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldxx.bean.User;
import com.ldxx.dao.UserDao;
import com.ldxx.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	@Override
	public int addUser(User user) {
		return dao.addUser(user);
	}

	@Override
	public int deleteUser(String userId) {
		return dao.deleteUser(userId);
	}

	@Override
	public int updateUser(User user) {
		return dao.updateUser(user);
	}

	@Override
	public List<User> selectAllUser() {
		return dao.selectAllUser();
	}

	@Override
	public User selectUserById(String userId) {
		return dao.selectUserById(userId);
	}

	@Override
	public int updUserup(User user) {
		return dao.updUserup(user);
	}
	
	@Override
	public int iscountWorkId(String workId) {
		return dao.iscountWorkId(workId);
	}

	@Override
	public List<User> getWorkIdAnduName() {
		return dao.getWorkIdAnduName();
	}

	@Override
	public User getWorkIdByuName(String uName) {
		return dao.getWorkIdByuName(uName);
	}

	@Override
	public User getuNameByWorkId(String workId) {
		return dao.getuNameByWorkId(workId);
	}

	@Override
	public int iscountUName(String uName) {
		return dao.iscountUName(uName);
	}

	@Override
	public int iscountWorkIdEdit(String workId, String userId) {
		return dao.iscountWorkIdEdit(workId, userId);
	}

	@Override
	public int iscountUNameEdit(String uName, String userId) {
		return dao.iscountUNameEdit(uName, userId);
	}

	@Override
	public User selectUserByUsername(String username) {
		return dao.selectUserByUsername(username);
	}


}
