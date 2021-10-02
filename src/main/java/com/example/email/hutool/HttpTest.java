package com.example.email.hutool;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class HttpTest {

    public static void main(String[] args) {
        String url = "http://localhost:8088/";//指定URL
        Map<String, Object> map = new HashMap<>();//存放参数
        map.put("name", "lzl");
        HashMap<String, String> headers = new HashMap<>();//存放请求头，可以存放多个请求头
//        headers.put("xxx", xxx);
        //发送get请求并接收响应数据
        String getResult = HttpUtil.createGet(url).addHeaders(headers).form(map).execute().body();
        System.out.println("getResult===" + getResult);
        //发送post请求并接收响应数据
        String postResult = HttpUtil.createPost(url).addHeaders(headers).form(map).execute().body();
        System.out.println("postResult===" + postResult);
    }

}
