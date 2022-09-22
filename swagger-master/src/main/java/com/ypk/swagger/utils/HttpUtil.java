package com.ypk.swagger.utils;

import com.alibaba.fastjson.JSONObject;
import org.asynchttpclient.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName HttpUtil * @Description TODO
 * @Author lgn
 * @Date 11:27 2022/9/21
 * @Version 1.0
 **/
public class HttpUtil {

    /**
    　　* @description: HTTP get方式传json格式
    　　* @param
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/9/21 11:58
    　　*/
    public static void doGet() throws ExecutionException, InterruptedException {
        DefaultAsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();

        String url = "http://localhost:8080/lab/mail/testEmail";

        Map<String, String> params = new HashMap<>();
        params.put("AppId", "appId");
        params.put("AppKey", "appKey");

        Request r = new RequestBuilder()
                .setUrl(url)
                .setBody(JSONObject.toJSONString(params))
                .addHeader("Content-Type", "application/json")
                .build();
        ListenableFuture<Response> future = asyncHttpClient.executeRequest(r);

        Response response = future.get();
        System.out.println(response.getResponseBody());
        asyncHttpClient.close();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doGet();

    }
}
