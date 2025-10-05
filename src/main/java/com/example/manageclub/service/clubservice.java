package com.example.manageclub.service;

import com.example.manageclub.model.clubs;
import com.example.manageclub.repo.clubrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clubservice {

    private clubrepo clubrepo1;

    @Autowired
    clubservice(clubrepo clubrepo){
        this.clubrepo1=clubrepo;
    }

    public List<clubs> getAllclubs(){
        return clubrepo1.findAll();
    }

    public clubs addClubs(clubs club1) {
        return clubrepo1.save(club1);
    }

    public void deleteclub(int id){
        clubrepo1.deleteById(id);
    }

    //if spring data jpa sees that an object has an id that is there in database
    //the jpa automatically updates and doesn't add a new cloumn
    //so here id is not needed just use save() without all getters and setters
    public void updateclub(int id, clubs club2) {
        Optional<clubs> existingclubopt = clubrepo1.findById(id);
        if(existingclubopt.isPresent()){
//            clubs existingclub= existingclubopt.get();
//            existingclub.setClubname(club2.getClubname());
//            existingclub.setDepartment(club2.getDepartment());
//            existingclub.setDescription(club2.getDescription());
//            existingclub.setInterviewdate(club2.getInterviewdate());
        clubrepo1.save(club2);
        }else{
            throw new RuntimeException("error in id doest match or id not found");
        }
    }
}
