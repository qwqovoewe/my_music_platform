package com.wrx.service;

import com.wrx.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
//    List<User> SelectAllUser();
//    void insertUser(User user0);
//    boolean userLogin(String username,String password);
    public User login(User user);

    void insertUser(User user);
}
