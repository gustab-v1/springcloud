package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;
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

    @Autowired
    private DeptClientService clientService;

    @RequestMapping("findAll")
    public List<Dept> findAll(){
        return clientService.findAll();
    }

    @RequestMapping("save")
    public Dept save(Dept dept){
        clientService.save(dept);
        return dept;
    }
}
