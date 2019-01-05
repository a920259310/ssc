package com.springboot.zcssc.http.proxy;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;

public class HttpProxyClientFactory {

    public static HttpClient getProxyHttpClient(String host, int port) throws IOException {

        //设置代理IP、端口、协议（请分别替换）

        HttpClient httpClient = new HttpClient();
        HostConfiguration hhh = new HostConfiguration();
        hhh.setProxy(host,port);

        httpClient.setHostConfiguration(hhh);


        //访问目标地址
        GetMethod getMethod = new GetMethod("http://localhost:8080");


        httpClient.executeMethod(getMethod);

        String responseBodyAsString = getMethod.getResponseBodyAsString();
        System.out.println(responseBodyAsString);


        return null;
    }

    public static void main(String[] args) throws IOException {
        HttpClient proxyHttpClient = getProxyHttpClient("81.200.54.91", 43455);
        System.out.println(proxyHttpClient);
    }

}
