package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "dept-provider")
public interface DeptClientService {
    @RequestMapping("dept/findAll")
    List<Dept> findAll();

    @RequestMapping("dept/save")
    Void save(Dept dept);
}
