package com.wrx.controller;

import com.wrx.domain.ResponseResult;
import com.wrx.domain.User;
import com.wrx.service.UserService;
import com.wrx.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class  UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseResult insertUser(@RequestBody User user){
        userService.insertUser(user);
        return new ResponseResult(200,"添加成功!");
    }
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        User loginUser = userService.login(user);
        //校验用户名密码
        Map<String, Object> map = new HashMap<>();
        if (loginUser != null) {
//成功，生产token
//
            String token = JwtUtil.createJWT(UUID.randomUUID().toString(),String.valueOf(loginUser.getUser_id()), null);
            map.put("token", token);
            return new ResponseResult(200, "登陆成功！", map);
        }
        else {
            return new ResponseResult(400, "用户名或密码错误，请重新登陆！");
        }

    }
}




