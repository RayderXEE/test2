package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class JsonPlaceHolder {

    @GetMapping("/test/{path}")
    public String get(@PathVariable String path) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("http://jsonplaceholder.typicode.com/" + path);
        ResponseEntity<String> response = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/" + path, String.class);
        return response.getBody();
    }

}
