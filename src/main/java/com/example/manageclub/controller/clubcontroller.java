package com.example.manageclub.controller;

import com.example.manageclub.model.clubs;
import com.example.manageclub.service.clubservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class clubcontroller
{
    private final clubservice clubservice;

    @Autowired
    clubcontroller(clubservice clubservice){
        this.clubservice=clubservice;
    }

    @RequestMapping("/")
    public String greet()
    {
        return "hello the server is running";
    }
    @RequestMapping("/getclubs")
    public ResponseEntity<List<clubs>> getAllclubs(){

        return new ResponseEntity<>(clubservice.getAllclubs(), HttpStatus.OK);
    }
    @PostMapping("/addclubs")
    public ResponseEntity<?> addclubs(@RequestBody clubs club){
        return new ResponseEntity<>(clubservice.addClubs(club),HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/deleteclub/{id}")
     public void deleteClub(@PathVariable int id) {
         clubservice.deleteclub(id);
    }
    @PutMapping("/updateclub/{id}")
    public void updateclub(@PathVariable int id, @RequestBody clubs club2){
        clubservice.updateclub(id, club2);
    }

}
 