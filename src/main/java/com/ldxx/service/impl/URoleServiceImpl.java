package com.ldxx.service.impl;

import com.ldxx.dao.URoleDao;
import com.ldxx.service.URoleService;
import com.ldxx.vo.URoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class URoleServiceImpl implements URoleService {

    @Autowired
    private URoleDao uRoleDao;


    @Override
    public List<URoleVo> selectRoleList() {
        List<URoleVo> roles = uRoleDao.selectRoleOneByCodeLength(4);
        List<URoleVo> newRoles = new ArrayList<>();
        for(URoleVo role:roles){
            String code = role.getRoleCode();
            List<URoleVo> roles2 = uRoleDao.selectRoleByCodeLike(code+"%",8);
            role.setNodes(roles2);
            newRoles.add(role);
        }
        return newRoles;
    }

    @Override
    public List<URoleVo> selectParentRoles() {
        return uRoleDao.selectRolesSort();
    }

    @Override
    public String addRoleByInput(String inputRoleName, String parentRole, String ifCouXiang) throws Exception {
        int result=5;
        List<URoleVo> rolesSort = uRoleDao.selectRolesSort();
        //确定角色编码   01   08
        String codeBasic = "";
        int key = 0;
        if(rolesSort!=null&&rolesSort.size()>0){
            Integer id = rolesSort.get(0).getId()+1;
            key=rolesSort.get(0).getId()+1;
            codeBasic = id.toString();
            if(codeBasic.length()==1){
                codeBasic="0"+codeBasic;
            }
        }else{
            codeBasic="01";
        }
        //parentRole 为0 则表明本次新建角色无父级角色  1有父角色
        //ifCouXiang 为0 则表明本次新建角色是抽象角色 1不是抽象角色

        if(ifCouXiang.equals("0")){
            URoleVo role = new URoleVo();
            if("0".equals(parentRole)){
                role.setId(key);
                role.setRoleCode("r"+codeBasic+"*.");
                role.setRoleSort(codeBasic);
                role.setRoleName(inputRoleName);
            }else{
                role.setId(key);
                role.setRoleCode(parentRole+"r"+codeBasic+"*.");
                role.setRoleSort(codeBasic);
                role.setRoleName(inputRoleName);
            }
            result = uRoleDao.addRole(role);
        }else{
            URoleVo role = new URoleVo();
            if("0".equals(parentRole)){
                role.setId(key);
                role.setRoleCode("r"+codeBasic+".");
                role.setRoleSort(codeBasic);
                role.setRoleName(inputRoleName);
            }else{
                role.setId(key);
                role.setRoleCode(parentRole+"r"+codeBasic+".");
                role.setRoleSort(codeBasic);
                role.setRoleName(inputRoleName);
            }
            result = uRoleDao.addRole(role);
        }
        return result+"";
    }

    @Override
    public List<URoleVo> selectRoleListById() {
        List<URoleVo> roles = uRoleDao.selectRoleOneByCodeLength(4);
        List<URoleVo> newRoles = new ArrayList<>();
        for(URoleVo role:roles){
            role.setParentRoleCode("0");
            String code = role.getRoleCode();
            List<URoleVo> roles2 = uRoleDao.selectRoleByCodeLike(code+"%",8);
            for(URoleVo role2 :roles2){
                role2.setParentRoleCode(role.getRoleCode());
            }
            role.setNodes(roles2);
            newRoles.add(role);
        }
        return newRoles;
    }

    @Override
    public int updatePersonRole(String personRoles, String personId) {
        return uRoleDao.updatePersonRole(personRoles,personId);
    }

    @Override
    public List<URoleVo> selectRolesSort() {
        return uRoleDao.selectRolesSort();
    }


}
