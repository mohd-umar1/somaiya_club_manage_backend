package com.example.manageclub.controller;

import com.example.manageclub.jwtUtil;
import com.example.manageclub.model.applications;
import com.example.manageclub.model.students;
import com.example.manageclub.repo.applicationrepo;
import com.example.manageclub.repo.studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/appliaction")
public class applicationcontroller {

    @Autowired
    public jwtUtil jwtutil;

    @Autowired
    public studentrepo studentrepo;

    @Autowired
    public applicationrepo applicationrepo;

    @PostMapping("/{clubname}")
    public ResponseEntity<String> saveApplication(@PathVariable String clubname, @RequestHeader("Authorization") String auth){

        String token = auth.substring(7).trim();

        String username = jwtutil.extractUsername(token);

        Optional<students> student = studentrepo.findByUsername(username);
        if(student.isEmpty()){
            return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
        }else{

            applications application = new applications(student.get(),clubname);
            applicationrepo.save(application);
            return new ResponseEntity<>("application sucessful", HttpStatus.ACCEPTED);
        }
    }
    @GetMapping("/getapplications/{clubname}")
    public ResponseEntity<List<applications>> getapplications(@PathVariable String clubname){
        if(!applicationrepo.getAllByClubname(clubname).get().isEmpty()) {
            return new ResponseEntity<>(applicationrepo.getAllByClubname(clubname).get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
        }
    }
}
