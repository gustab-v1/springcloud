package com.tongtu.user.web;

import com.tongtu.user.pojo.User;
import com.tongtu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 校验数据
     * @param data
     * @param type
     * @return
     */
    @GetMapping("/check/{data}/{type}")
    public ResponseEntity<Boolean> checkData(@PathVariable("data") String data, @PathVariable("type") Integer type){
        return ResponseEntity.ok(userService.checkData(data,type));
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/findAllUser")
    public ResponseEntity<List<User>> findAllUser(){
        return ResponseEntity.ok(userService.findAllUser());
    }

    @PostMapping("/findUser")
    public ResponseEntity<User> findByUsernameAndPassword(@PathVariable("username") String username,
                                                          @PathVariable("password") String password){
        return ResponseEntity.ok(userService.findByUsernameAndPassword(username,password));
    }
}
