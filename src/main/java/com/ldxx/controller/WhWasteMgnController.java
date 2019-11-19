package com.ldxx.controller;

import com.ldxx.bean.WhWasteMgn;
import com.ldxx.service.WhWasteMgnService;
import com.ldxx.vo.WhWasteMgnVo;
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
    public List<WhWasteMgnVo> getAllWhWasteMgn() {
        return service.getAllWhWasteMgn();
    }

    /**
     *
     * @param id 废料id
     * @param warningState 废料状态
     * @param batchId 批次id
     * @return
     */
    @RequestMapping("/updwarningState")
    public int updwarningState(String id, int warningState,String batchId) {
        return service.updwarningState(id,warningState,batchId);
    }

    @RequestMapping("/insertWhWasteMgn")
    public int insertWhWasteMgn(WhWasteMgn WhWasteMgn) {
        return service.insertWhWasteMgn(WhWasteMgn);
    }
}
