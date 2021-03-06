package com.ldxx.controller;

import com.ldxx.bean.GuizeCar;
import com.ldxx.bean.GuizeYujing;
import com.ldxx.bean.TruckInfo;
import com.ldxx.dao.GuizeDao;
import com.ldxx.service.GuizeService;
import com.ldxx.service.TruckInfoService;
import com.ldxx.util.LDXXUtils;
import com.ldxx.vo.GuizeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
    private GuizeService service;

    @Resource
    private GuizeDao guizeDao;

    private Map<String, Object> map = new HashMap<>();

    @RequestMapping("/getAllGuize")
    @ResponseBody
    public List<GuizeVo> getAllGuizeVos() {
        List list = service.getAllGuizeVo();
        return list;
    }

    @RequestMapping("/getAllGuizeYujingByTime")
    @ResponseBody
    public List<GuizeYujing> getAllGuizeYujingByTime(String id, String startTime, String endTime) {
        List list = guizeDao.getAllGuizeYujingByCarId(id, startTime, endTime);
        return list;
    }

    @RequestMapping("/Guize")
    @ResponseBody
    public TruckInfo getTruckInfoById(String id) {

        return null;
    }

    @RequestMapping("/addGuizeAndCars")
    @ResponseBody
    public int addGuizeAndPlates(@RequestBody GuizeVo guizeVo) {
        guizeVo.setGuizeId(LDXXUtils.getUUID12());
        int i = service.insertGuizeVo(guizeVo);
        return i;
    }

    @RequestMapping("/deleteGuizeAndCarsAndPoints")
    @ResponseBody
    public int deleteGuizeAndCarsAndPoints(String guizeId) {
        int i = service.deleteGuizeAndCarsAndPoints(guizeId);
        return i;
    }

    @RequestMapping("/updateGuizeAndCars")
    @ResponseBody
    public int updateGuizeAndPlates(@RequestBody GuizeVo guizeVo) {
        guizeVo.setGuizeId(LDXXUtils.getUUID12());
        int i = service.updateGuizeVo(guizeVo);
        return i;
    }

    @RequestMapping("/delTruckInfo")
    @ResponseBody
    public int delTruckInfo(String id) {
        return 1;
    }

    @RequestMapping("/insertTruckInfo")
    @ResponseBody
    public Map<String, Object> insertTruckInfo(TruckInfo t) {
        return null;
    }
}
