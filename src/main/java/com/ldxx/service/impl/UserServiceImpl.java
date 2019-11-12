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
		// TODO Auto-generated method stub
		return dao.deleteUser(userId);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return dao.selectAllUser();
	}

	@Override
	public User selectUserById(String userId) {
		// TODO Auto-generated method stub
		return dao.selectUserById(userId);
	}

	@Override
	public int updUserup(User user) {
		// TODO Auto-generated method stub
		return dao.updUserup(user);
	}

}
