package com.example.manageclub.controller;

import com.example.manageclub.model.students;
import com.example.manageclub.service.studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentapi")
@CrossOrigin
public class studentcontroller {

    public studentservice studentservice;

    @Autowired
    public studentcontroller(studentservice studentservice){
        this.studentservice = studentservice;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> savestudents(@RequestBody students student1){
        return new ResponseEntity<>(studentservice.savestudents(student1), HttpStatus.OK);
    }
    @GetMapping("/getstudents")
    public ResponseEntity<List<students>> getstudents(){
        return new ResponseEntity<>(studentservice.getstudents(),HttpStatus.OK);
    }
}
