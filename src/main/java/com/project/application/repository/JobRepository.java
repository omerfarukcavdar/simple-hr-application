package com.project.application.repository;

import com.project.application.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Integer> {

    List<Job> findAll();
}
