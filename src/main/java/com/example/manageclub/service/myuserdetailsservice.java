package com.example.manageclub.service;

import com.example.manageclub.model.mystudentdetails;
import com.example.manageclub.model.students;
import com.example.manageclub.repo.studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class myuserdetailsservice implements UserDetailsService {


    private studentrepo repo;

    @Autowired
    public myuserdetailsservice(studentrepo repo){

        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        students student = repo.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("username not found"));

        return new mystudentdetails(student);
    }
}
