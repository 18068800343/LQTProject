package com.ldxx.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 孤
 * @version v1.0
 * @Developers 张耀烽
 * @serviceProvider 四叶草安全(SeClover)
 * @description 获取Application配置数据
 * @date
 */
@Component
public class ApplicationValues {

    @Value("${http_pool.max_total}")
    private int maxTotal;

    @Value("${http_pool.default_max_per_route}")
    private int maxPerRoute;

    @Value("${http_pool.connect_timeout}")
    private int connTimeOut;

    @Value("${http_pool.connection_request_timeout}")
    private int connReqTimeOut;

    @Value("${http_pool.socket_timeout}")
    private int socketTimeout;

    @Value("${http_pool.validate_after_inactivity}")
    private int inactivity;


    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxPerRoute() {
        return maxPerRoute;
    }

    public void setMaxPerRoute(int maxPerRoute) {
        this.maxPerRoute = maxPerRoute;
    }

    public int getConnTimeOut() {
        return connTimeOut;
    }

    public void setConnTimeOut(int connTimeOut) {
        this.connTimeOut = connTimeOut;
    }

    public int getConnReqTimeOut() {
        return connReqTimeOut;
    }

    public void setConnReqTimeOut(int connReqTimeOut) {
        this.connReqTimeOut = connReqTimeOut;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public int getInactivity() {
        return inactivity;
    }

    public void setInactivity(int inactivity) {
        this.inactivity = inactivity;
    }
}