package com.chengxiaoxiao;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Cheng Xiaoxiao
 * 签发token时，设置过期时间
 */

public class JwtContainTime {
    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder().setId("666").setSubject("小马").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "chengxiaoxiao").setExpiration(new Date(new Date().getTime() + 2 * 60 * 60 * 1000)).claim("role", "admin");

        System.out.printf(jwtBuilder.compact());

        //解析
        Claims claims = Jwts.parser().setSigningKey("chengxiaoxiao").parseClaimsJws(jwtBuilder.compact()).getBody();

        System.out.printf("role:" + claims.get("role"));

    }
}
