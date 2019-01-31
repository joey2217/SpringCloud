package com.joey.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joey.jwt.constant.Constants;
import com.joey.jwt.entity.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author EDZ
 * @create 2019-01-30 13:49
 * @desc JWTLoginFilter
 * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法
 * attemptAuthentication ：接收并解析用户凭证。
 * successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     * 接收并解析用户凭证
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserEntity userEntity = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userEntity.getUsername(),
                            userEntity.getPassword(),
                            new ArrayList<>()
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     * 用户成功登录后，这个方法会被调用，我们在这个方法里生成token
     */
    @ApiOperation(value = "自定义登录")
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // builder the token
        String token =null;
        try{
            Collection<? extends GrantedAuthority> authorities=authResult.getAuthorities();
            // 定义存放角色集合的对象
            List roles=new ArrayList<>();
            for (GrantedAuthority grantedAuthority : authorities) {
                roles.add(grantedAuthority.getAuthority());
            }
            // 设置过期时间
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            // 30天
            calendar.add(Calendar.DAY_OF_MONTH, 30);
            /* 1分钟 calendar.add(Calendar.MINUTE, 1); */

            Date date = calendar.getTime();
            //
            token = Jwts.builder()
                    .setSubject(authResult.getName()+"-"+roles)
                    .setExpiration(date)
                    .signWith(SignatureAlgorithm.HS256, Constants.SIGNING_KEY)
                    .compact();
            //登录成功后，返回token到header里面
            response.addHeader("Authorization","Jwt "+token);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
