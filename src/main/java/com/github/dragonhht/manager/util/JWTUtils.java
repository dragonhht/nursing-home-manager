package com.github.dragonhht.manager.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.Set;

/**
 * Description.
 * User: huang
 * Date: 18-9-28
 */
@Component
public class JWTUtils {

    @Value("${jwt.secret}")
    private String secript;

    /**
     * 创建token.
     * @param id 手机号
     * @return token
     */
    public String createTocken(String id, long issued, String subject, Set<String> roles) {
        String[] tokenRoles = (String[]) roles.toArray();
        String token = "";
        try {
            Algorithm algorithm = Algorithm.HMAC256(secript);
            token = JWT.create()
                    .withIssuer(id)
                    .withIssuedAt(new Date(issued))
                    .withSubject(subject)
                    .withArrayClaim("roles", tokenRoles)
                    // .withExpiresAt(new Date(issued + ConfigCode.EXP_TIME))
                    .sign(algorithm);
        } catch (UnsupportedEncodingException exception){
        } catch (JWTCreationException exception){
        }
        return token;
    }

    /**
     * 解析token.
     * @param token token
     * @return
     */
    public DecodedJWT check(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secript);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt;
        } catch (UnsupportedEncodingException exception){
        } catch (JWTVerificationException exception){
        }
        return null;
    }

    /**
     * 判断token是否有效.
     * @param token token
     * @return
     */
    public boolean isEffective(String token) {
        boolean ok = false;
        DecodedJWT jwt = check(token);
        if (jwt != null) {
            ok = true;
        }
        return ok;
    }

    /**
     * 获取token数据.
     * @param token
     * @return
     */
    public String getTokenMessage(String token) {
        DecodedJWT jwt = check(token);
        return base64Decoder(jwt.getPayload());
    }

    public String base64Decoder(String s) {
        return new String(Base64.getDecoder().decode(s));
    }
}
