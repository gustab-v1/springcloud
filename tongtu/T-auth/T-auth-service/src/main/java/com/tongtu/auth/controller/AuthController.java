package com.tongtu.auth.controller;

import com.tongtu.auth.config.JwtProperties;
import com.tongtu.auth.pojo.UserInfo;
import com.tongtu.auth.service.AuthService;
import com.tongtu.auth.utils.JwtUtils;
import com.tongtu.common.utils.CookieUtils;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Data
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("login")
    public ResponseEntity<Void> login(
            @RequestParam("username")String username, @RequestParam("password")String password,
            HttpServletRequest request, HttpServletResponse response)
    {
        //调用service方法生成jwt
        String token = authService.login(username,password);
        if(StringUtils.isBlank(token)){
            return ResponseEntity.badRequest().build();
        }
        //把token设置给cookie
        CookieUtils.setCookie(request,response,"LY_TOKEN",token,jwtProperties.getExpire() * 60,"utf-8");
        return ResponseEntity.ok().build();
    }

    @GetMapping("verify")
    public ResponseEntity<UserInfo> verify(@CookieValue("LY_TOKEN")String token,
                                           HttpServletRequest request, HttpServletResponse response
    ){
        try {
            //使用公钥解析jwt，获取用户信息
            UserInfo userInfo = JwtUtils.getUserInfo(jwtProperties.getPublicKey(), token);
            if (userInfo == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            //刷新jwt过期时间：本质是重新生成jwt
            token = JwtUtils.generateToken(userInfo,jwtProperties.getPrivateKey(),jwtProperties.getExpire() * 60);
            //刷新cookie的过期时间
            CookieUtils.setCookie(request,response,"LY_TOKEN",token,jwtProperties.getExpire() * 60,null);
            return ResponseEntity.ok(userInfo);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
