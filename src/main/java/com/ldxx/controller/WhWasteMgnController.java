package com.ldxx.controller;

import com.ldxx.bean.User;
import com.ldxx.bean.WhWasteMgn;
import com.ldxx.service.WhWasteMgnService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.vo.WhWasteMgnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
     * @return
     */
    @RequestMapping("/updwarningState")
    public int updwarningState(String id, int warningState, HttpSession session) {
        return service.updwarningState(id,warningState,session);
    }

    @RequestMapping("/insertWhWasteMgn")
    public int insertWhWasteMgn(WhWasteMgn whWasteMgn,HttpSession session) {
    	User user = (User) session.getAttribute("user");
		if(null!=user) {
			whWasteMgn.setDealUserId(user.getUserId());
			whWasteMgn.setDealTime(GetThisTimeUtils.getDateTime());
		}
        return service.insertWhWasteMgn(whWasteMgn);
    }
}
