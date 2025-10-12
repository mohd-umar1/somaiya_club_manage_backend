package com.example.manageclub.repo;

import com.example.manageclub.model.applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface applicationrepo extends JpaRepository<applications,Integer> {

    Optional<List<applications>> getAllByClubname(String clubname);
}
