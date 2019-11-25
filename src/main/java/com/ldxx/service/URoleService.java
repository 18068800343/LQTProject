package com.ldxx.service;

import com.ldxx.bean.URole;
import com.ldxx.vo.URoleVo;

import java.util.List;

public interface URoleService {

     List<URoleVo> selectRoleList();

    List<URoleVo> selectParentRoles();

    String addRoleByInput(String inputRoleName, String parentRole, String ifCouXiang) throws Exception;

    List<URoleVo> selectRoleListById();

    int updatePersonRole(String personId, String personRoles);

    List<URoleVo> selectRolesSort();

    int updURoleVoById(URoleVo uRole);

    int upduPersmissionCoding(URole uRole);
}
