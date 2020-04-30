package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
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
    public Dept save(@RequestBody Dept dept){
        deptService.saveDept(dept);
        return dept;
    }
}
