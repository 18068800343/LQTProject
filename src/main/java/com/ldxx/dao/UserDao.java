package com.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldxx.bean.User;

public interface  UserDao {
	
	int addUser(@Param("user")User user );
	
	int deleteUser(@Param("userId")String userId);
	
	int updateUser(@Param("user")User user);
	
	List<User> selectAllUser();
	
	User selectUserById(@Param("userId")String userId);
	
	int updUserup(@Param("user")User user);

}
