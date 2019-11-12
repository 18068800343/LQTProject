package com.ldxx.service;

import java.util.List;
import com.ldxx.bean.User;

public interface UserService {
	
	int addUser(User user );
	
	int deleteUser(String userId);
	
	int updateUser(User user);
	
	List<User> selectAllUser();
	
	User selectUserById(String userId);
	
	int updUserup(User user);
}
