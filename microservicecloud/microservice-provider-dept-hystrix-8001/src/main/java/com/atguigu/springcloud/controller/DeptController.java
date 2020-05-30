package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dept")
public class DeptController {
    @Autowired
    DeptService deptService;

    @RequestMapping("findAll")
    public List<Dept> findAll(){
        return deptService.findAll();
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept save(@RequestBody Dept dept){

        if(dept.getDname().equals("123")){
            throw new RuntimeException("无法添加该信息");
        }
        deptService.saveDept(dept);
        return dept;
    }
    public Dept processHystrix_Get(@RequestBody Dept dept){
        Dept dept1 = new Dept();
        dept1.setDname("无法添加该名称："+dept.getDname());
        return dept1;
    }
}
