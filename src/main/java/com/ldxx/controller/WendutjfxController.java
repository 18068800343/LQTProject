package com.ldxx.controller;

import com.ldxx.bean.Wendutjfx;
import com.ldxx.dao.WendutjfxDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wendutjfx")
public class WendutjfxController {

    @Autowired
    private WendutjfxDao dao;

    @RequestMapping("/getWendutjfx")
    public List<Wendutjfx> getWendutjfx(){
        List<Wendutjfx> list=dao.getWendutjfx();
        return list;
    }
}
