package com.wrx.mapper;

import com.wrx.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    User login(User user);

    void insertUser(User user);
//    List<User> SelectAlluser();
//
//    void insertUser(User user0);
//
//    User selectByUsername(String username);

}
