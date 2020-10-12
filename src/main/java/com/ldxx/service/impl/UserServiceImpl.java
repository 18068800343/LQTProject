package com.ldxx.service.impl;

import com.ldxx.bean.Accessory;
import com.ldxx.bean.SysRoadMgn;
import com.ldxx.bean.User;
import com.ldxx.dao.AccessoryDao;
import com.ldxx.dao.SysRoadMgnDao;
import com.ldxx.dao.URoleDao;
import com.ldxx.dao.UserDao;
import com.ldxx.service.UserService;
import com.ldxx.vo.URoleVo;
import com.ldxx.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	@Autowired
	private URoleDao uRoleDao;
	@Autowired
	private SysRoadMgnDao srmDao;
	@Autowired
	private AccessoryDao accessoryDao;

	@Override
	public int addUser(User user) {
		int num= dao.addUser(user);
		if(num>0){
			List<Accessory> accessory = user.getAccessory();
			if(accessory!=null&&accessory.size()!=0){
				accessoryDao.addAccessory(accessory);
			}
		}
		return num;
	}

	@Override
	public int deleteUser(String userId) {
		return dao.deleteUser(userId);
	}

	@Override
	public int updateUser(User user) {
		int num= dao.updateUser(user);
		if(num>0){
			List<Accessory> accessory = user.getAccessory();
			if(accessory!=null&&accessory.size()!=0){
				accessoryDao.addAccessory(accessory);
			}
		}
		return num;
	}

	@Override
	public List<UserVo> selectAllUser() {
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
	public UserVo selectUserByUsername(String username) {
        UserVo user = dao.selectUserByUsername(username);
        if(user==null)
        {
        	return null;
        }
        //查询编码名称
        String uPermissions = "";
        String userRole = user.getUserRole();
        if(null!=userRole&&!"".equals(userRole)){
            String[] userRoles = userRole.split("_");

            for(String roleCode:userRoles){
				List<URoleVo> roles = uRoleDao.selectRoleByRoleCode(roleCode);
				if (roles.size() > 0) {
					uPermissions = uPermissions + "," + roles.get(0).getuPersmissionCoding();
				}
			}

        }
        if(uPermissions.length()>1){
            uPermissions = uPermissions.substring(1, uPermissions.length());
            user.setuPermissions(uPermissions);
        }
        //查询路段权限名称
		String luduanquanxian = user.getLuduanquanxian();
        String luduanquanxianName="";
		if(null!=luduanquanxian && !"".equals(luduanquanxian)){
			String[] ldquanxian = luduanquanxian.split(",");
			for (String luduan:ldquanxian){
				SysRoadMgn byIdSysRoadMgn = srmDao.selectSysRoadMgnById(luduan);
				if(byIdSysRoadMgn!=null){
					luduanquanxianName=luduanquanxianName+","+byIdSysRoadMgn.getRoadName();
				}
			}
		}
		if(luduanquanxianName.length()>0){
			luduanquanxianName=luduanquanxianName.substring(1,luduanquanxianName.length());
			user.setLuduanquanxianName(luduanquanxianName);
		}
		return user;
	}

	@Override
	public List<UserVo> selectUserAndRoles() {
		List<UserVo> users = dao.selectAllUser();

		for(UserVo user:users){
			String userRoleNames = "";
			String userRole = user.getUserRole();
			if(null!=userRole&&!"".equals(userRole)){
				String[] userRoles = userRole.split("_");

				for(String roleCode:userRoles){
					List<URoleVo> roles = uRoleDao.selectRoleByRoleCode(roleCode);
					if(roles.size()>0){
						userRoleNames=userRoleNames+"，"+roles.get(0).getRoleName();
					}
				}

			}
			if(userRoleNames.length()>1){
				userRoleNames = userRoleNames.substring(1, userRoleNames.length());
				user.setUserRoleNames(userRoleNames);
			}
		}
		return users;
	}
	@Override
	public int updatePasswordById(String userId, String new_password) {
		return dao.updatePasswordById(userId,new_password);
	}

	@Override
	//uList1 拥有唯一路段 uList 拥有其他路段
	public Map<String,List> selectUserByRoadId(String roadId) {
		Map<String,List> map = new HashMap<>();
		roadId=roadId.replace(" ","");
		List<User> uList= dao.selectUserByRoadId("%"+roadId+"%");
		List<User> uList1=new ArrayList<User>();
		List<User> uList2=new ArrayList<User>();
		for(User u :uList)     //查找只有拥有该路段的用户，替换掉空格，逗号和该路段id，如果长度等于0，说明没有其他路段了。
		{
			int length = u.getLuduanquanxian()
					.replace(roadId,"")
					.replace(",","")
					.replace(" ","").length();
			if(length==0)
			{
				uList1.add(u);
			}else{
				uList2.add(u);
			}

		}
		map.put("uList1",uList1);
		map.put("uList2",uList2);
		return map;
	}

}
