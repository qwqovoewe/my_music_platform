package com.wrx.service.serviceimpl;

import com.wrx.domain.User;
import com.wrx.mapper.UserMapper;
import com.wrx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class userServiceImpl implements UserService {

//    @Autowired
//    UserMapper userMapper;
//    @Override
//    public List<User> SelectAllUser() {
//        return userMapper.SelectAlluser();
//    }
//
//    @Override
//    public void insertUser(User user0) {
//        userMapper.insertUser(user0);
//    }
//
//    @Override
//    public boolean userLogin(String username, String password) {
//        User user=userMapper.selectByUsername(username);
//        return password.equals(user.getPassword());
//    }
    @Autowired
private UserMapper userMapper;
    @Override
    public User login(User user) {
       User loginUser= userMapper.login(user);
       return loginUser;
    }

    @Override
    public void insertUser(User user) {
        //需要从前端传过来
        userMapper.insertUser(user);
    }
}
