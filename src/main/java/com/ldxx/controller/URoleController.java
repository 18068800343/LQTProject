package com.ldxx.controller;

import com.ldxx.service.URoleService;
import com.ldxx.vo.URoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色管理
 */

@RestController
@RequestMapping("URole")
public class URoleController {

    @Autowired
    private URoleService uRoleService;

    @RequestMapping("/getRolesList")
    public List<URoleVo> getRolesList(){
        List<URoleVo> roles = uRoleService.selectRoleList();
        return roles;
    }
    @RequestMapping("/initRoleListById")
    @ResponseBody
    public List<URoleVo> initRoleListById(){
        List<URoleVo> roles = uRoleService.selectRoleListById();
        return roles;
    }
    @RequestMapping("/updateParentRole")
    public int  updateParentRole(String personId,String personRoles){
        if("".equals(personRoles.trim())){
            personRoles="";
        }else{
            personRoles = personRoles.substring(0,personRoles.length()-1);
        }
        int i = uRoleService.updatePersonRole(personId, personRoles);
        return i;
    }
    @RequestMapping("/getParentRoles")
    public List<URoleVo> getParentRoles(){
        List<URoleVo> roles = uRoleService.selectRoleList();
        return roles;
    }

    @RequestMapping("/addRole")
    public String addRole(String inputRoleName,String parentRole,String ifCouXiang){
        String aString = "";
        try {
            aString = uRoleService.addRoleByInput(inputRoleName, parentRole, ifCouXiang);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aString;
    }

    @RequestMapping("/selectRolesSort")
    public List<URoleVo> selectRolesSort(){
        List<URoleVo> roles = uRoleService.selectRolesSort();
        return roles;
    }

}
