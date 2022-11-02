package com.example.demo;


import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;

//@Service
@RestController()
@RequestMapping("config")
public class Config {

    public static void main(String[] args) {
        Config config = new Config();
        System.out.println(config.getCookie());
    }

    @GetMapping("cookie")
    @SneakyThrows
    public String getCookie() {
        return IOUtils.toString(new FileInputStream("config/cookie.txt"));
    }

}
