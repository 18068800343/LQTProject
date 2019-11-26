package com.ldxx.controller;

import com.ldxx.bean.UPermissionsRole;
import com.ldxx.dao.UPermissionsRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Permissions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限编码
 */

@RestController
@RequestMapping("UPermissionsRole")
public class UPermissionsRoleController {

    @Autowired
    private UPermissionsRoleDao dao;

    @RequestMapping("/getAllUPermissionsRole")
    public Map<String,Object> getAllUPermissionsRole(){
        Map<String,Object> map=new HashMap<>();
        List<UPermissionsRole> list= dao.getAllUPermissionsRole();
        map.put("list",list);
        List<UPermissionsRole> list1=new ArrayList<>();
        List<UPermissionsRole> list2=new ArrayList<>();
        List<UPermissionsRole> list3=new ArrayList<>();
        List<UPermissionsRole> list4=new ArrayList<>();
        List<UPermissionsRole> list5=new ArrayList<>();
        List<UPermissionsRole> list6=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getCoding().length()==3){//一级菜单栏
                list1.add(list.get(i));
                map.put("list1",list1);
            }else if(list.get(i).getCoding().length()==4){//二级子菜单栏
                list2.add(list.get(i));
                map.put("list2",list2);
            }else if(list.get(i).getCoding().length()==5){//三级子菜单栏
                list3.add(list.get(i));
                map.put("list3",list3);
            }else if(list.get(i).getCoding().length()==6){//四级子菜单栏
                list4.add(list.get(i));
                map.put("list4",list4);
            }else if(list.get(i).getCoding().length()==7){//五级子菜单栏
                list5.add(list.get(i));
                map.put("list5",list5);
            }else{										//六级子菜单栏
                list6.add(list.get(i));
                map.put("list6",list6);
            }
        }
        return map;
    }

}
