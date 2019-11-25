package com.ldxx.service;

import java.util.List;

import com.ldxx.bean.User;
import com.ldxx.vo.UserVo;

public interface UserService {
	
	int addUser(User user );
	
	int deleteUser(String userId);
	
	int updateUser(User user);
	
	List<UserVo> selectAllUser();
	
	User selectUserById(String userId);
	
	int updUserup(User user);
	
	int iscountWorkId(String workId);

	List<User> getWorkIdAnduName();
	
	User getWorkIdByuName(String uName);

	User getuNameByWorkId(String workId);

	int iscountUName(String uName);
	
	int iscountWorkIdEdit(String workId,String userId);
	
	int iscountUNameEdit(String uName,String userId);

	UserVo selectUserByUsername(String username);

    List<UserVo> selectUserAndRoles();
    
    int updatePasswordById(String userId, String new_password);
}
