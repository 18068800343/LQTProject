package com.ldxx.controller;

import com.ldxx.bean.Accessory;
import com.ldxx.bean.User;
import com.ldxx.service.UserService;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.getWebFileUtils;
import com.ldxx.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	private Map<String,Object> map=new HashMap<>();
	
	@RequestMapping("/addUser")
	@ResponseBody
    public Map<String,Object> addUser(User user,@RequestParam("file") MultipartFile[] file) throws IOException {
		int i=0;
		int iscountWorkId = service.iscountWorkId(user.getWorkId());
		int iscountUName = service.iscountUName(user.getuName());
		String id = LDXXUtils.getUUID12();
		if(iscountWorkId>0){
			i=-1;
		}else if(iscountUName>0){
			i=-2;
		}else{
			String webFile = getWebFileUtils.getWebFile();
			String path=webFile+"user_File";
			File f=new File(path);
			if(!f.exists()){
				f.mkdirs();
			}
			if(file.length>0){
				List<Accessory> list=new ArrayList<>();
				for(int j=0;j<file.length;j++){
					Accessory accessory=new Accessory();
					String fileName=file[j].getOriginalFilename();
					String filePath=path+File.separator+fileName;
					File f2=new File(filePath);
					file[i].transferTo(f2);
					accessory.setaId(id);
					accessory.setAcName(fileName);
					accessory.setAcUrl(filePath);
					accessory.setaType("人员合同附件");
					list.add(accessory);
				}
				user.setAccessory(list);
			}
			user.setUserId(id);
			i= service.addUser( user );
		}
		//service.selectUserById(user.getUserId());
        map.put("result", i);
        map.put("user", user);
        return map;
    }
	 
	@RequestMapping("/deleteUser")
	@ResponseBody
    public int deleteUser(String userId) {
        return service.deleteUser( userId );
    }
	
	@RequestMapping("/updateUser")
	@ResponseBody
    public Map<String,Object> updateUser(User user,HttpServletRequest request,@RequestParam("file") MultipartFile[] file) throws IOException {
		int i=0;
		int iscountWorkIdEdit = service.iscountWorkIdEdit(user.getWorkId(),user.getUserId());
		int iscountUNameEdit = service.iscountUNameEdit(user.getuName(),user.getUserId());
		if(iscountWorkIdEdit>0){
			i=-1;
		}else if(iscountUNameEdit>0){
			i=-2;
		}else{
			String webFile = getWebFileUtils.getWebFile();
			String path=webFile+"user_File";
			File f=new File(path);
			if(!f.exists()){
				f.mkdirs();
			}
			if(file.length>0){
				List<Accessory> list=new ArrayList<>();
				for(int j=0;j<file.length;j++){
					Accessory accessory=new Accessory();
					String fileName=file[j].getOriginalFilename();
					String filePath=path+File.separator+fileName;
					File f2=new File(filePath);
					file[i].transferTo(f2);
					accessory.setaId(user.getUserId());
					accessory.setAcName(fileName);
					accessory.setAcUrl(filePath);
					accessory.setaType("人员合同附件");
					list.add(accessory);
				}
				user.setAccessory(list);
			}
			i= service.updateUser(user);
			HttpSession session = request.getSession();
			user = service.selectUserById(user.getUserId());
			User suser = (User)session.getAttribute("user");
			if(suser!=null&&suser.getUserId().equals(user.getUserId()))
			{
				session.setAttribute("user",user);
			}
		}


        map.put("result",i);
        map.put("user",user);
        return map;
    }
	
	@RequestMapping("/updUserup")
	@ResponseBody
	public int updUserup(User user){
		return service.updUserup(user);
	}
	
	@RequestMapping("/selectAllUser")
	@ResponseBody
	public List<UserVo> selectAllUser(){
		return service.selectAllUser();
	}
	
	@RequestMapping("/selectUserById")
	@ResponseBody
	public User selectUserById(String userId){
		return service.selectUserById(userId);
	}

	
	@RequestMapping("/getWorkIdAnduName")
	@ResponseBody
	public List<User> getWorkIdAnduName(){
		return service.getWorkIdAnduName();
	}
	
	@RequestMapping("/getWorkIdByuName")
	@ResponseBody
	public User getWorkIdByuName(String uName){
		return service.getWorkIdByuName(uName);
	}
	
	@RequestMapping("/getuNameByWorkId")
	@ResponseBody
	public User getuNameByWorkId(String workId){
		return service.getuNameByWorkId(workId);
	}

	@RequestMapping("/selectUserAndRoles")
	@ResponseBody
	public List<UserVo> selectUserAndRoles(){
		List<UserVo> list =service.selectUserAndRoles();
		return list;

	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/updatePasswordById")
	@ResponseBody
	public int updatePasswordById(String userId,String password){
		String old_password = password.split(",")[0];
		String new_password = password.split(",")[1];
		User user = service.selectUserById(userId);
		int i=0;
		if(!user.getPassword().equals(old_password)){
			i=-1;
		}else if(user.getPassword().equals(new_password)){
			i=-2;
		}else{
			i=service.updatePasswordById(userId,new_password);
		}
		return i;
	}

	/**
	 * 通过用户名查询用户信息
	 * @param username
	 * @return
	 */
	@RequestMapping("/selectUserByUsername")
	@ResponseBody
	public UserVo selectUserByUsername(String username){
		return service.selectUserByUsername(username);
	}

	/**
	 * 通过路段Id查询拥有唯一该路段id的用户
	 * @param
	 * @return
	 */
	@RequestMapping("/selectUserByRoadIdIsOne")
	@ResponseBody
	public List<User> selectUserByRoadId(String roadId){
		List<User> uList1 = service.selectUserByRoadId(roadId).get("uList1");
		return uList1;
	}

}
