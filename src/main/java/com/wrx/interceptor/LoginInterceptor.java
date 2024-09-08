package com.wrx.interceptor;

import com.wrx.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //获取请求头中的token
        String token = request.getHeader("token");
        if(!StringUtils.hasText(token)){
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            throw new RuntimeException("未登录，请重新登录!");
        }
        //解析token，判断如果为空，返回401响应
        try {
            Claims claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            //解析过程无异常则为登录状态,有则401
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            throw new RuntimeException("未登录，请重新登录!");
        }
        return true;


    }
}

