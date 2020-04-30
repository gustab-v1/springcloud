package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 消费端
 */
@RestController
@RequestMapping("consumer")
public class DeptController_Consumer {
    private final String REST_URL_PREFIX = "http://127.0.0.1:8001";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("findAll")
    public List<Dept> findAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/findAll",List.class);
    }

    @RequestMapping("save")
    public Dept save(Dept dept){
        restTemplate.postForObject(REST_URL_PREFIX+"/dept/save",dept,Dept.class);
        return dept;
    }
}
