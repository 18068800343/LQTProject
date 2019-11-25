package com.ldxx.controller;

import com.ldxx.bean.UPermissionsRole;
import com.ldxx.dao.UPermissionsRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 权限编码
 */

@RestController
@RequestMapping("UPermissionsRole")
public class UPermissionsRoleController {

    @Autowired
    private UPermissionsRoleDao dao;

    @RequestMapping("/getAllUPermissionsRole")
    public List<UPermissionsRole> getAllUPermissionsRole(){
        return dao.getAllUPermissionsRole();
    }

}
