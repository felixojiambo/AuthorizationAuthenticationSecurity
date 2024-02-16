//package com.zep.ldls.user.util;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.zep.ldls.user.model.User;
//import io.jsonwebtoken.io.IOException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//import static org.springframework.security.config.Elements.JWT;
//
//public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    public JWTAuthenticationFilter (AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Override
//    public Authentication attemptAuthentication (HttpServletRequest req, HttpServletResponse res) {
//        try {
//            User creds = new ObjectMapper().readValue(req.getInputStream(), User.class);
//
//            return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            creds.getUsername(),
//                            creds.getPassword(),
//                            new ArrayList<>())
//            );
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest req,
//                                            HttpServletResponse res,
//                                            FilterChain chain,
//                                            Authentication auth) throws IOException, ServletException {
//
//        String token = JWT.create()
//                .withSubject(((User) auth.getPrincipal()).getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .sign(HMAC512(SECRET.getBytes()));
//        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
//    }
//}