package com.example.manageclub.repo;

import com.example.manageclub.model.clubs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clubrepo extends JpaRepository<clubs,Integer>{}
