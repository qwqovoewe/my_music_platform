package com.wrx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer user_id;
    private String username;
    private String password;
    private String nickname;
    private String hobby;
    private char sex;
}
