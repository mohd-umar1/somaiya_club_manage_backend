package com.example.manageclub.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class clubs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String clubname;
    private String department;
    private String description;
   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date interviewdate;

}
