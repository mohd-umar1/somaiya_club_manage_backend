package com.example.manageclub.service;

import com.example.manageclub.model.students;
import com.example.manageclub.repo.studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentservice {

    public studentrepo studentrepo;

    @Autowired
    public studentservice(studentrepo studentrepo){

        this.studentrepo =studentrepo;
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public Object savestudents(students student1) {
        student1.setPassword(encoder.encode(student1.getPassword()));
        return studentrepo.save(student1);
    }

    public List<students> getstudents() {

        return studentrepo.findAll();
    }
}
