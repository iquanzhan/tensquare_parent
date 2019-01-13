package com.chengxiaoxiao;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @author Cheng Xiaoxiao
 */
public class jwt {
    public static void main(String[] args) {
        //创建token
       /* JwtBuilder jwtBuilder = Jwts.builder()
                .setId("666")
                .setSubject("小马")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"chengxiaoxiao");
        System.out.printf(jwtBuilder.compact());*/


       //解析token
        Claims claims = Jwts.parser().setSigningKey("chengxiaoxiao")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1NDczNjQyNTN9.oNBo_dzF4dVgPt_m6PsnHvWr435LtLLHDZfOuZOyGNQ")
                .getBody();

        System.out.printf(claims.getId());

    }
}
