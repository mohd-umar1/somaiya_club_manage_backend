package com.example.manageclub.model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
public class mystudentdetails implements UserDetails {


    private String name;
    private String department;
    private String yearofstudy;
    private Long phone_number;
    private String email_id;
    private String role;
    private String username;
    private String password;

    public mystudentdetails(students student1){
        this.username = student1.getUsername();
        this.password = student1.getPassword();
        this.name = student1.getName();
        this.department=student1.getDepartment();
        this.yearofstudy = student1.getYearofstudy();
        this.phone_number = student1.getPhone_number();
        this.email_id = student1.getEmail_id();
        this.role = student1.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_"+role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
