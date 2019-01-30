package com.joey.jwt.filter;

import com.joey.jwt.constant.Constants;
import com.joey.jwt.exception.TokenException;
import com.joey.jwt.service.impl.GrantedAuthorityImpl;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author EDZ
 * @create 2019-01-30 11:47
 * @desc
 *   自定义JWT认证过滤器
 *   该类继承自BasicAuthenticationFilter，在doFilterInternal方法中，
 *   从http头的Authorization 项读取token数据，然后用Jwts包提供的方法校验token的合法性。
 *   如果校验通过，就认为这是一个取得授权的合法请求
 */
@Slf4j
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        if (header == null||!header.startsWith("Jwt ")) {
            chain.doFilter(request,response);
            return;
        }

    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
        long start = System.currentTimeMillis();
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            throw new TokenException("Token为空");
        }
        // parse the token.
        String user = null;
        try {
            user= Jwts.parser()
                    .setSigningKey(Constants.SIGNING_KEY)
                    .parseClaimsJws(token.replace("Jwt ",""))
                    .getBody()
                    .getSubject();
            long end = System.currentTimeMillis();
            log.info("执行时间: {}", (end - start) + " 毫秒");
            if (user == null) {
                String[] userArr = user.split("-")[1].split(",");
                List<GrantedAuthority> authorities=new ArrayList<>();
                for (int i = 0; i <userArr.length; i++) {
                    authorities.add(new GrantedAuthorityImpl(userArr[i]));
                }
                return new UsernamePasswordAuthenticationToken(user,null,authorities);
            }
        }catch (){}
        return null;
    }
}
