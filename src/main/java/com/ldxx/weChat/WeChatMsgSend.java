package com.ldxx.weChat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class WeChatMsgSend {

    private CloseableHttpClient httpClient;

    /**
     * 用于提交登录数据
     */
    private HttpPost httpPost;

    /**
     * 用于获得登陆后页面
     */
    private HttpGet httpGet;

    public static final String CONTENT_TYPE = "Content-Type";

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static Gson gson = new Gson();

    /**
     * 微信授权请求，GET类型，获取授权响应，用于其他方法截取token
     *
     * @param Get_Token_Url
     * @return String 授权响应内容
     * @throws IOException
     */
    protected String toAuth(String Get_Token_Url) throws IOException {
        httpClient = HttpClients.createDefault();
        httpGet = new HttpGet(Get_Token_Url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        String resp = "";

        try {
            HttpEntity entity = response.getEntity();
            resp = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            response.close();
        }
        return resp;
    }

    /**
     * corpid应用组织编号 corpsecret应用秘钥 获取toAuth(String
     * Get_Token_Url)返回结果中键值对中access_token键的值
     *
     * @param
     */
    public String getToken(String corpid, String corpsecret) throws IOException {
        WeChatMsgSend sw = new WeChatMsgSend();
        WeChatUrlData uData = new WeChatUrlData();
        uData.setGet_Token_Url(corpid, corpsecret);
        String resp = sw.toAuth(uData.getGet_Token_Url());
        System.out.println("resp=====:" + resp);
        try {
            Map<String, Object> map = gson.fromJson(resp, new TypeToken<Map<String, Object>>() {
            }.getType());
            return map.get("access_token").toString();
        } catch (Exception e) {
            e.getStackTrace();
            return resp;
        }
    }

    /**
     * 创建微信发送请求post数据 touser发送消息接收者 ，msgtype消息类型（文本/图片等）， application_id应用编号。
     * 本方法适用于text型微信消息，contentKey和contentValue只能组一对
     *
     * @param touser
     * @param msgtype
     * @param application_id
     * @param contentKey
     * @param contentValue
     * @return
     */
    public String createpostdata(String touser, String msgtype, int application_id, String contentKey,
                                 String contentValue) {
        WeChatData wcd = new WeChatData();
        wcd.setTouser(touser);
        wcd.setAgentid(application_id + "");
        wcd.setMsgtype(msgtype);
        Map<Object, Object> content = new HashMap<Object, Object>();
        content.put(contentKey, contentValue);
        wcd.setText(content);
        return gson.toJson(wcd);
    }


    public String createPostDataApp(String touser, String title, String description, String key, String value) {
        WeChatData2 wcd = new WeChatData2();
        wcd.setTouser(touser);
        wcd.setToparty("");
        wcd.setTotag("");
        wcd.setMsgtype("miniprogram_notice");

        Map[] s = new Map[1];
        Map<Object, Object> content_item = new HashMap<Object, Object>();
        content_item.put("key", key);
        content_item.put("value", value);
        s[0] = content_item;

        Map<Object, Object> miniprogram_notice = new HashMap<Object, Object>();

        miniprogram_notice.put("appid", "wx4bc136cb6f83cacf");
        miniprogram_notice.put("page", "pages/dlsgzlgl/dlsgIndex");
        miniprogram_notice.put("title", title);
        miniprogram_notice.put("description", description);
        miniprogram_notice.put("emphasis_first_item", true);
        miniprogram_notice.put("content_item", s);

        wcd.setMiniprogram_notice(miniprogram_notice);
        wcd.setEnable_id_trans("0");
        wcd.setEnable_duplicate_check("0");
        return gson.toJson(wcd);
    }


    /**
     * @Title 创建微信发送请求post实体，charset消息编码    ，contentType消息体内容类型，
     * url微信消息发送请求地址，data为post数据，token鉴权token
     * @param charset
     * @param contentType
     * @param url
     * @param data
     * @param token
     * @return
     * @throws IOException
     */
    public String post(String charset, String contentType, String url, String data, String token) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        httpPost = new HttpPost(url + token);
        httpPost.setHeader(CONTENT_TYPE, contentType);
        httpPost.setEntity(new StringEntity(data, charset));
        CloseableHttpResponse response = httpclient.execute(httpPost);
        String resp;
        try {
            HttpEntity entity = response.getEntity();
            resp = EntityUtils.toString(entity, charset);
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }
        return resp;
    }
}
