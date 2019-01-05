package com.springboot.zcssc.zcssc.controller;

import com.springboot.zcssc.utils.IpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(HttpServletRequest httpServletRequest) {
        String ipAddr = IpUtil.getIpAddr(httpServletRequest);
        System.out.println(ipAddr);
        return "Greetings from Spring Boot!";
    }

}

