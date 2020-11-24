package com.tongtu.user.api;

import com.tongtu.user.pojo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface UserApi {
    @GetMapping("/check/{data}/{type}")
    Boolean checkData(@PathVariable("data") String data, @PathVariable("type") Integer type);

    @PostMapping("/findUser")
    User findByUsernameAndPassword(@PathVariable("username") String username, @PathVariable("password") String password);
}
