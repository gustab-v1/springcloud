package com.tongtu.user.service;

import com.tongtu.common.enums.ExceptionEnum;
import com.tongtu.common.exception.TException;
import com.tongtu.user.mapper.UserMapper;
import com.tongtu.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Boolean checkData(String data, Integer type) {
        // 判断数据类型
        User record = new User();
        switch (type){
            case 1:
                record.setUsername(data);
                break;
            case 2:
                record.setPhone(data);
                break;
            default:
                throw new TException(ExceptionEnum.USER_DATA_TYPE_ERROR);
        }
        int count = userMapper.selectCount(record);
        return count == 0 ? true : false;
    }

    public List<User> findAllUser(){
        return userMapper.selectAll();
    }

    public User findByUsernameAndPassword(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        User select = userMapper.selectOne(user);
        return select;
    }
}
