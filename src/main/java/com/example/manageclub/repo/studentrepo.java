package com.example.manageclub.repo;

import com.example.manageclub.model.students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentrepo extends JpaRepository<students,Integer> {
}
