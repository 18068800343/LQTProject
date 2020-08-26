package com.ldxx.controller;

import com.ldxx.bean.TruckInfo;
import com.ldxx.service.TruckInfoService;
import com.ldxx.util.LDXXUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车辆管理
 *
 * @author hp
 */

@Controller
@RequestMapping("Guize")
public class GuizeController {

    @Autowired
    private TruckInfoService service;

    private Map<String, Object> map = new HashMap<>();

    @RequestMapping("/getAllGuize")
    @ResponseBody
    public List<TruckInfo> getAllTruckInfo() {
        return service.getAllTruckInfo();
    }

    @RequestMapping("/Guize")
    @ResponseBody
    public TruckInfo getTruckInfoById(String id) {
        return service.getTruckInfoById(id);
    }

    @RequestMapping("/addGuizeAndCars")
    @ResponseBody
    public Map<String, Object> updTruckInfo(TruckInfo t) {
        int i = service.updTruckInfo(t);
        map.put("result", i);
        map.put("TruckInfo", t);
        return map;
    }

    @RequestMapping("/delTruckInfo")
    @ResponseBody
    public int delTruckInfo(String id) {
        return service.delTruckInfo(id);
    }

    @RequestMapping("/insertTruckInfo")
    @ResponseBody
    public Map<String, Object> insertTruckInfo(TruckInfo t) {
        t.setId(LDXXUtils.getUUID12());
        int i = service.insertTruckInfo(t);
        map.put("result", i);
        map.put("TruckInfo", t);
        return map;
    }
}
