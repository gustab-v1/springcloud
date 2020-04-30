package com.atguigu;

import com.atguigu.springcloud.dao.DeptDao;
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.ref.PhantomReference;
import java.util.List;

@SpringBootTest
public class test {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DeptDao deptDao;

    @Test
    public void test1(){
        Dept dept = new Dept(1l,"研发部","mysql");
        deptService.saveDept(dept);


        List<Dept> all = deptService.findAll();
        System.out.println(all);
    }
}
