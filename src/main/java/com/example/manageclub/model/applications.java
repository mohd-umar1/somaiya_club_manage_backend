package com.example.manageclub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class applications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    private String name;
    private String department;
    private String yearofstudy;
    private Long phone_number;
    private String email_id;
    private String clubname;
    private Date interviewdate;

    public applications(students student1, String clubname){
        this.name=student1.getName();
        this.department=student1.getDepartment();
        this.yearofstudy= student1.getYearofstudy();
        this.email_id= student1.getEmail_id();
        this.phone_number=student1.getPhone_number();
        this.clubname = clubname;
    }
}
