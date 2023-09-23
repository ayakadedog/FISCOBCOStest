package com.example.fiscodemo3.Controller;

import com.example.fiscodemo3.client.UserClient;
import com.example.fiscodemo3.entity.User;
import com.example.fiscodemo3.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/user")

public class UserController {

    @Resource
    public UserClient userClient;

    @PostMapping("/login")
    public Result<Void> Login(@RequestBody User user){
        log.info("login start run");
        userClient.Login(user.getUsername(), user.getPassword());
        return Result.success();
    }

    @PostMapping("/register")
    public Result<Void> Register(@RequestBody User user){
        log.info("register start run");
        userClient.Login(user.getUsername(), user.getPassword());
        return Result.success();
    }

}
