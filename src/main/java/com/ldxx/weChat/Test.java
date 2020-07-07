package com.ldxx.weChat;

public class Test {

    public static void main(String[] args) {
        WeChatMsgSend swx = new WeChatMsgSend();
        try {
            //getToken参数1 corpid 企业id    参数2  应用秘钥
//            String token = swx.getToken("ww8dad70e28c6446b8", "3H5uzjWkB80kpwP0Qj2rWeKyfZaY1ZiPOXFLUGOb_Fg");
            String token = swx.getToken("ww8dad70e28c6446b8", "9vCyCQz7nT2cgcDjR-2bIab6jCNqaFilZS8_0ikEuLs");
            String postdata = swx.createpostdata("ziiq", "text", 1000003, "content", "这是一条测试信息");
            String postdata1 = swx.createPostDataApp("ZhenFeng", "温度预警通知", "12月17日 16:16", "温度值", "40");
            String resp = swx.post("utf-8", WeChatMsgSend.CONTENT_TYPE, (new WeChatUrlData()).getSendMessage_Url(), postdata1, token);
            System.out.println("获取到的token======>" + token);
            System.out.println("请求数据======>" + postdata1);
            System.out.println("发送微信的响应数据======>" + resp);

        }catch (Exception e) {
            e.getStackTrace();
        }
    }
}
