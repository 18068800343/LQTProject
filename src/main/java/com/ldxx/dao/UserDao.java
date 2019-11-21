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
	
	int iscountWorkId(@Param("workId")String workId);

	List<User> getWorkIdAnduName();
	
	User getWorkIdByuName(@Param("uName")String uName);

	User getuNameByWorkId(@Param("workId")String workId);

	int iscountUName(@Param("uName")String uName);
	
	int iscountWorkIdEdit(@Param("workId")String workId,@Param("userId")String userId);
	
	int iscountUNameEdit(@Param("uName")String uName,@Param("userId")String userId);
	
	User selectUserByUsername(@Param("username")String username);
}
