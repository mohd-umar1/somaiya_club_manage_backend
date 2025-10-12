package com.example.manageclub.repo;

import com.example.manageclub.model.students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface studentrepo extends JpaRepository<students,Integer> {

    Optional<students> findByUsername(String username);

    List<students> username(String username);
}
