package com.ldxx.controller;

import com.ldxx.bean.DicDepartment;
import com.ldxx.service.DicDepartmentService;
import com.ldxx.util.LDXXUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("DicDepartment")
public class DicDepartmentController {

    private Map<String,Object> map=new HashMap<>();

    @Autowired
    private DicDepartmentService service;

    @RequestMapping("/getAllDicDepartment")
    public List<DicDepartment> getAllDicDepartment() {
        return service.getAllDicDepartment();
    }

    @RequestMapping("/insertDicDepartment")
    public Map<String,Object> insertDicDepartment(DicDepartment dicDepartment) {
        dicDepartment.setId(LDXXUtils.getUUID12());
        int i=0;
        DicDepartment d = service.getDicDepartmentByName(dicDepartment.getDepartmentName());
        if(null!=d &&null!= d.getDepartmentName())
        {
            i=-1;
        }else {
            i= service.insertDicDepartment(dicDepartment);
        }
        map.put("result", i);
        map.put("dicDepartment", dicDepartment);
        return map;

    }

    @RequestMapping("/delDicDepartment")
    public int delDicDepartment(String id) {
        return service.delDicDepartment(id);
    }

    @RequestMapping("/updateDicDepartmentById")
    public Map<String,Object> updateDicDepartmentById(DicDepartment dicDepartment) {
        int i=0;
        DicDepartment d = service.getDicDepartmentByName(dicDepartment.getDepartmentName());
        if(null!=d &&null!= d.getDepartmentName())
        {
            i=-1;
        }else {
            i= service.updateDicDepartmentById(dicDepartment);
        }
        map.put("result", i);
        map.put("dicDepartment", dicDepartment);
        return map;

    }

    @RequestMapping("/getDicDepartmentById")
    public DicDepartment getDicDepartmentById(String id) {
        return service.getDicDepartmentById(id);
    }

}
