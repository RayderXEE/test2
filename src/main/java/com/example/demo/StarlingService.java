package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;

@Service @AllArgsConstructor
public class StarlingService {

    Config config;

    @SneakyThrows
    public String doRequest(String url, String body) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        ObjectMapper mapper = new ObjectMapper();
        //Config config = mapper.readValue(new File("config.json"), Config.class);
        headers.add("Cookie", config.getCookie());

        HttpEntity<String> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, request, String.class);

        return responseEntity.getBody();
    }

}
