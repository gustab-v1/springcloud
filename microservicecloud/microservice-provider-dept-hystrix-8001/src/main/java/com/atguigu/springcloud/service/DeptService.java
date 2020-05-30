package com.atguigu.springcloud.service;

import com.atguigu.springcloud.dao.DeptDao;
import com.atguigu.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeptService {
    @Autowired
    private DeptDao deptDao;

    public List<Dept> findAll(){
        List<Dept> depts = deptDao.findAll();
        return depts;
    }

    @Transactional
    public void saveDept(Dept dept){
        deptDao.save(dept);
    }
}
