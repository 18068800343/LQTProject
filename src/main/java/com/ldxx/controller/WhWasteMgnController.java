package com.ldxx.controller;

import com.ldxx.bean.WhWasteMgn;
import com.ldxx.service.WhWasteMgnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 废料管理
 */

@RestController
@RequestMapping("WhWasteMgn")
public class WhWasteMgnController {

    @Autowired
    private WhWasteMgnService service;

    @RequestMapping("/getAllWhWasteMgn")
    public List<WhWasteMgn> getAllWhWasteMgn() {
        return service.getAllWhWasteMgn();
    }

    @RequestMapping("/updwarningState")
    public int updwarningState(String id, int warningState) {
        return service.updwarningState(id,warningState);
    }

    @RequestMapping("/insertWhWasteMgn")
    public int insertWhWasteMgn(WhWasteMgn WhWasteMgn) {
        return service.insertWhWasteMgn(WhWasteMgn);
    }
}
