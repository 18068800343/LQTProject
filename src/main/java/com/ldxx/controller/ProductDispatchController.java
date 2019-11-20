package com.ldxx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldxx.bean.ProductDispatch;
import com.ldxx.bean.User;
import com.ldxx.service.ProductDispatchService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;
import com.ldxx.util.MsgFormatUtils;
import com.ldxx.vo.ProductDispatchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 成品砼调度
 */
@RestController
@RequestMapping("ProductDispatch")
public class ProductDispatchController {

    @Autowired
    private ProductDispatchService service;

    @RequestMapping("/getAllProductDispatch")
    public List<ProductDispatchVo> getAllProductDispatch(){
        return service.getAllProductDispatch();
    }

    @RequestMapping("/delProductDispatch")
    public int delProductDispatch(String id){
        return service.delProductDispatch(id);
    }

    @RequestMapping("/insertProductDispatch")
    public String insertProductDispatch(@RequestBody ProductDispatchVo productDispatchVo, HttpSession session){
        JSONObject jsonObject=new JSONObject();
        productDispatchVo.setId(LDXXUtils.getUUID12());
        productDispatchVo.setDispatchTime(GetThisTimeUtils.getDateTime());
        productDispatchVo.setEditDatetime(GetThisTimeUtils.getDateTime());
        User user = (User) session.getAttribute("user");
        if(null!=user) {
            productDispatchVo.setEditUserId(user.getUserId());
            productDispatchVo.setuName(user.getuName());
        }
        int i = service.insertProductDispatch(productDispatchVo);
        String msg = MsgFormatUtils.getMsgByResult(i, "调度");
            jsonObject.put("result",i);
        jsonObject.put("msg",msg);
        jsonObject.put("obj",productDispatchVo);

        return jsonObject.toString();
    }

}
