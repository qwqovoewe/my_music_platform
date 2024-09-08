//package com.wrx.controller;
//
//import com.wrx.domain.User;
//import com.wrx.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class HelloController {
//
//    @Autowired
//    private UserService userservice;
//
//
//   @RequestMapping("/user/login11")
//    public List<User> hello() {
//        return userservice.SelectAllUser();
//    }
//
//    @PostMapping("/user/insertUser")
//    public void insertUser(@RequestBody User user0){
//       userservice.insertUser(user0);
//    }
//
//}
