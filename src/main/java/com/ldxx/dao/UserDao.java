package com.ldxx.dao;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.User;

public interface  UserDao {
	
	int addUser(@Param("user")User user );

}
