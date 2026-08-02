package com.example.manageclub;

import com.example.manageclub.model.mystudentdetails;
import com.example.manageclub.service.myuserdetailsservice;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
@Component
public class JWTauthfilter extends OncePerRequestFilter {

    @Autowired
    public jwtUtil jwtUtil;

    @Autowired
    public myuserdetailsservice myuserdetailsservice;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       try {
           String token = jwtUtil.get_jwt_from_header(request);
           if (token != null && jwtUtil.validateToken(token)) {

               String Username = jwtUtil.extractUsername(token);

               UserDetails user = myuserdetailsservice.loadUserByUsername(Username);
               if (user != null) {
                   UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                   authentication.setDetails(
                           new WebAuthenticationDetailsSource()
                                   .buildDetails(request)
                   );
                   SecurityContextHolder.getContext().setAuthentication(authentication);
               }
           }
       }catch (Exception e) {
           e.printStackTrace();
           throw new RuntimeException(e);
       }

       filterChain.doFilter(request, response);
    }
}
