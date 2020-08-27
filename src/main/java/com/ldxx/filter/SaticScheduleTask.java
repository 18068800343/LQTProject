package com.ldxx.filter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ldxx.util.RestMock;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {

    @Resource
    RestMock restMock;

    @Resource

    //3.添加定时任务
    @Scheduled(cron = "0/30 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        String url = "58.222.201.158:6809/deviceData/allRealData.do";
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("key", "f30da8ee-61da-4c1a-bd73-54fee1d19d69");
        jsonMap.put("filterTime", 0);
        String str = restMock.sendGet(url, jsonMap);

        System.out.println(str);
        if (!"".equals(str)) {
            JSONObject jsonObject = JSONObject.parseObject(str);
            JSONArray object = jsonObject.getJSONObject("obj").getJSONArray("data");
            System.out.println(object);

        }
    }

}