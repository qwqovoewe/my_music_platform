package com.wrx.service.serviceimpl;

import com.wrx.aop.InvokeLog;
import com.wrx.domain.User;
import com.wrx.mapper.UserMapper;
import com.wrx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class userServiceImpl implements UserService {

    @Autowired
private UserMapper userMapper;

    @Override
    public Integer update(User user) {
       return userMapper.upateUser(user);

    }

    @Override
    @InvokeLog//对方法进行aop增强
    public User login(User user) {
       User loginUser= userMapper.login(user);
       return loginUser;
    }

    @Override
//    @Transactional//声明式事务判断
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public boolean registerJudge(User user) {
        if(userMapper.registerJudge(user).equals(1))
            return false;
        else
            return true;

    }

    @Override
    public User show(User user) {
        return userMapper.show(user);
    }

    @Override
    public void insertList(User user) {
        userMapper.insertList(user);
    }


    @Override
    public Integer getUserID(User user) {
        return userMapper.getUserID(user);
    }

    @Override
    public User showfromname(User user) {
        return userMapper.showFromname(user);
    }

}
