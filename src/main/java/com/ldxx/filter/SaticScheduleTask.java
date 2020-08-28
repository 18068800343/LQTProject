package com.ldxx.filter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ldxx.bean.GuizeYujing;
import com.ldxx.bean.Point;
import com.ldxx.dao.GuizeDao;
import com.ldxx.util.DistanceUtil;
import com.ldxx.util.RestMock;
import com.ldxx.vo.GuizeCarVo;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {

    @Resource
    RestMock restMock;

    @Resource
    GuizeDao guizeDao;
    //3.添加定时任务
    @Scheduled(cron = "0/20 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
//        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        String url = "58.222.201.158:6809/deviceData/allRealData.do";
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("key", "f30da8ee-61da-4c1a-bd73-54fee1d19d69");
        jsonMap.put("filterTime", 20);
        String str = restMock.sendGet(url, jsonMap);

//        System.out.println(str);
        if (!"".equals(str)) {
            JSONObject jsonObject = JSONObject.parseObject(str);
            JSONArray jsonArray = jsonObject.getJSONObject("obj").getJSONArray("data");
//            System.out.println(jsonArray);
            String carIdStr = guizeDao.getDistinctAllCar();
            for (Iterator iterator = jsonArray.iterator(); iterator.hasNext(); ) {
                JSONObject item = (JSONObject) iterator.next();
                //车辆ID
                String carId = item.getString("id");
                //车牌号
                String plate = item.getString("plate");
                String gpsTime = item.getString("gpsTime");
                //0：从未上线 1：行驶 2：停车 3：离线 4：服务到期
                String vehicleStatus = item.getString("vehicleStatus");
                Double alng = item.getDouble("lon");
                Double alat = item.getDouble("lat");
                if ("1".equals(vehicleStatus)) {
                    if (!"".equals(carIdStr) && carIdStr.contains(carId)) {
                        List<Point> points = guizeDao.getPointsByCarId(carId);
                        Double distance = DistanceUtil.getMinDistanceByList(alng, alat, points);
                        String guizeId = "";
                        if (null != points && points.size() > 0) {
                            guizeId = points.get(0).getGuizeId();
                        }
                        if (distance > 50) {
                            GuizeYujing guizeYujing = new GuizeYujing(carId, alng.toString(), alat.toString(), vehicleStatus, plate, distance.toString(), gpsTime, guizeId);
                            int i = guizeDao.insertGuizeYujing(guizeYujing);
                            if (i > 0) {
//                                System.out.println("*******插入预警信息成功********");
                            }
                        }
                    }
                }
            }
        }
    }

}