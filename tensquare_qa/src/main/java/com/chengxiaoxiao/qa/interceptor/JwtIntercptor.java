package com.chengxiaoxiao.qa.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;
import util.JwtUtil;

/**
 * @author Cheng Xiaoxiao
 */
@Component
public class JwtIntercptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && !"".equals(authorization)) {
            if (authorization.startsWith("Bearer ")) {
                String token = authorization.substring(7);
                try {
                    Claims claims = jwtUtil.parseJWT(token);
                    String role = (String) claims.get("roles");

                    if(role!=null&&role.equals("admin")){
                        request.setAttribute("claims_admin",token);
                    }

                    if(role!=null&&role.equals("admin")){
                        request.setAttribute("claims_user",token);
                    }

                } catch (Exception e) {
                    throw new RuntimeException("权限不足");
                }
            }
        }

        return true;
    }
}
