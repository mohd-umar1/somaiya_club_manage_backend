package com.example.manageclub.controller;

import com.example.manageclub.jwtUtil;
import com.example.manageclub.model.mystudentdetails;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class logincontroller {

    private final com.example.manageclub.jwtUtil jwtUtil;
    public AuthenticationManager authenticationManager;

    public logincontroller(AuthenticationManager authenticationManager, jwtUtil jwtUtil){
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public static class login{
        public String username;
        public String password;
    }

    @PostMapping("/login")
    public String loginrequset(@RequestBody login login1){
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(login1.username, login1.password);
        Authentication authentication = authenticationManager.authenticate(token);

        mystudentdetails studentdetials = (mystudentdetails) authentication.getPrincipal();

        return jwtUtil.generatetoken(studentdetials);
    }

}
