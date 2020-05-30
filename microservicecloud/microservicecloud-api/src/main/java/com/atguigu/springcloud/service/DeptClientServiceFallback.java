package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallback implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public List<Dept> findAll() {
                List<Dept> list = null;
                list.add(new Dept(0l,"查询出错",null));
                return list;
            }

            @Override
            public Void save(Dept dept) {
                return null;
            }
        };
    }
}
