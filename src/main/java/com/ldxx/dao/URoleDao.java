package com.ldxx.dao;

import com.ldxx.bean.URole;
import com.ldxx.vo.URoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface URoleDao {

    int addRole(URoleVo uRole);

    int updatePersonRole(String personId, String personRoles);

    List<URoleVo> selectRoleOneByCodeLength(Integer length);

    List<URoleVo> selectRoleTwoByCodeLength(Integer length);

    List<URoleVo> selectRoleByCodeLike(String code, Integer length);

    List<URoleVo> selectRolesSort();

    List<URoleVo> selectRoleByRoleCode(String roleCode);

    URoleVo selectRoleById(String id);

    List<URoleVo> selectRoleByRoleName(String name);

    int updURoleVoById(URoleVo uRole);

    int upduPersmissionCoding(URole uRole);
}
