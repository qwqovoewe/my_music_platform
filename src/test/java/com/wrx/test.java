package com.wrx;

import com.wrx.utils.JwtUtil;
import org.junit.Test;

import java.util.UUID;

public class test {


    @Test
    public void test(){
        String jwt = JwtUtil.createJWT(UUID.randomUUID().toString(), "1", null);
        System.out.println(jwt);

    }
}
