package com.wrx.mapper;

import com.wrx.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    Integer upateUser(User user);

    User login(User user);

    Integer registerJudge(User user);

    User show(User user);


    void insertList(User user);

    Integer getUserID(User user);

    void insertUser(User user);

    User showFromname(User user);
}
