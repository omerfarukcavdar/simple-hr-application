package com.project.application.service;

import com.project.application.model.Applicant;
import com.project.application.model.Job;

import java.util.List;

public interface ApplicantService {

    Applicant save(Applicant applicant);

    Boolean delete(int id);

    Applicant update(Applicant applicant);

    Applicant findById(int id);

    List<Applicant> findAll();

    List<Applicant> findAllByJob(Job job);

}
