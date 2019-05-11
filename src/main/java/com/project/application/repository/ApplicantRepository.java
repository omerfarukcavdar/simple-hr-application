package com.project.application.repository;

import com.project.application.model.Applicant;
import com.project.application.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant,Integer> {

    List<Applicant> findAll();

    List<Applicant> findAllByJob(Job job);


}
