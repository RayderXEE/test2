package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DTAListProviderFromFindAllTaskInfoService {

    public static void main(String[] args) {
        DTAListProviderFromFindAllTaskInfoService findAllTaskInfoService =
                new DTAListProviderFromFindAllTaskInfoService(new StarlingService(new Config()));
        String dtaList = findAllTaskInfoService.getDTAList();
        System.out.println(dtaList);
    }

    private StarlingService starlingService;

    @GetMapping("dtalist")
    public String getDTAList() {
        try {
            String list = starlingService.doRequest(
                    "http://app-ru.huawei.com/hq_Russia_eurasia/services/api/dynamic/workflow/findalltaskinfo",
                    "{\"page\":1,\"pageSize\":500,\"userCode\":\"f84271284\",\"taskStatus\":\"0\",\"businessParams\":{},\"queryParams\":{\"currentHandler\":\"rWX357392\",\"createdDt\":{\"OPERATOR\":\"BETWEEN\",\"OPERAND\":[\"2022-10-21\",\"2100-12-31\"]},\"createdDtStart\":\"2022-10-21\",\"createdDtEnd\":\"2100-12-31\"}}");
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNodeList = mapper.readValue(list, JsonNode.class).get("tasks");

            return jsonNodeList.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }

    }
}
