package com.ldxx.weChat;

public class Test {

    public static void main(String[] args) {
        WeChatMsgSend swx = new WeChatMsgSend();
        try {
            //corpid 企业id
            String token = swx.getToken("ww8dad70e28c6446b8","3H5uzjWkB80kpwP0Qj2rWeKyfZaY1ZiPOXFLUGOb_Fg");
            String postdata = swx.createpostdata("ZiiQ", "text", 1000002, "content","这是一条测试信息");
            String resp = swx.post("utf-8", WeChatMsgSend.CONTENT_TYPE,(new WeChatUrlData()).getSendMessage_Url(), postdata, token);
            System.out.println("获取到的token======>" + token);
            System.out.println("请求数据======>" + postdata);
            System.out.println("发送微信的响应数据======>" + resp);
        }catch (Exception e) {
            e.getStackTrace();
        }
    }
}
