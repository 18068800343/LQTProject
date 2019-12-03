package com.ldxx.service;

import java.util.List;
import java.util.Map;

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

	/**
	 *
	 * @param roadId
	 * @return uList1拥有唯一的路段的用户,uList2拥有不是唯一的路段的用户
	 */
	Map<String,List> selectUserByRoadId(String roadId);
}
