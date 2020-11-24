package com.leyou.auth.service;

import com.leyou.auth.config.JwtProperties;
import com.leyou.auth.pojo.UserInfo;
import com.leyou.auth.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(JwtProperties.class)
public class AuthService {
    @Autowired
    private  JwtProperties jwtProperties;
    public String login(String username, String password) {
        //远程调用用户中心的查询接口
        //判断是否为空
        //初始化载荷信息
        UserInfo userInfo = new UserInfo();
        userInfo.setId(100L);
        userInfo.setUsername("adminnnnn");
        //生成jwt类型token
        try {
             return JwtUtils.generateToken(userInfo, jwtProperties.getPrivateKey(), jwtProperties.getExpire());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
}
