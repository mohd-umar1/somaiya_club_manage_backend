package com.example.manageclub.service;

import com.example.manageclub.model.students;
import com.example.manageclub.repo.studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentservice {

    public studentrepo studentrepo;

    @Autowired
    public studentservice(studentrepo studentrepo){
        this.studentrepo =studentrepo;
    }

    public Object savestudents(students student1) {
       return studentrepo.save(student1);
    }

    public List<students> getstudents() {
        return studentrepo.findAll();
    }
}
