package com.wrx.controller;

import com.wrx.domain.ResponseResult;
import com.wrx.domain.User;
import com.wrx.resolver.CurrentUserId;
import com.wrx.service.UserService;
import com.wrx.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        if(userService.registerJudge(user)) {
            userService.insertUser(user);
            //对重名时的判断
            return new ResponseResult(200, "添加成功!");
        }
        else{
            return new ResponseResult(300,"用户名已经被注册，请重试！");
        }
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
            return new ResponseResult(300, "用户名或密码错误，请重新登陆！");
        }

    }

    @PostMapping("/editor")
    public ResponseResult editor(@RequestBody User user, @CurrentUserId String id){
    Map<String,Object> map =new HashMap<>();
        Integer id1 = Integer.valueOf(id);
        user.setUser_id(id1);
        map.put("nickname", user.getNickname());
        map.put("password", user.getPassword());
        map.put("sex",user.getSex());
        map.put("hobby", user.getHobby());
    if(userService.update(user)!=0){
    return  new ResponseResult(200,"您已编辑成功!",map);
    }
    else{
        return  new ResponseResult(300,"编辑失败，请重试！");
        }
    }
    @GetMapping("/show")
    public ResponseResult show(User user, @CurrentUserId String id){
        Map<String,Object> map =new HashMap<>();
        Integer id1 = Integer.valueOf(id);
        user.setUser_id(id1);
        User user1 =userService.show(user);
        map.put("nickname", user1.getNickname());
        map.put("password", user1.getPassword());
        map.put("sex",user1.getSex());
        map.put("hobby", user1.getHobby());
        return new ResponseResult(200,"",map);
    }
}




