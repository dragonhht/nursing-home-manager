package com.github.dragonhht.manager.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.dragonhht.manager.util.JWTUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Description.
 * User: huang
 * Date: 18-11-12
 */
public class JWTFilter extends BasicHttpAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        String token = ((HttpServletRequest) request).getHeader("token");
        if (token != null) {
            DecodedJWT jwt = check(token);
            if (jwt != null) {
                try {
                    executeLogin(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public DecodedJWT check(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("nures");
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt;
        } catch (UnsupportedEncodingException exception){
        } catch (JWTVerificationException exception){
        }
        return null;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("token");
        DecodedJWT jwt = check(token);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(jwt.getIssuer(), new String(Base64Utils.decodeFromString(jwt.getSubject())));
        SecurityUtils.getSubject().login(usernamePasswordToken);
        return true;
    }
}
