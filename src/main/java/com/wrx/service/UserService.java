package com.wrx.service;

import com.wrx.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Integer update(User user);

    List<User> selectAll();
    public User login(User user);

    void insertUser(User user);

    public boolean registerJudge(User user);


    User show(User user);

    void insertList(User user);

    Integer getUserID(User user);

    User showfromname(User user);
}
