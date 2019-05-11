package com.project.application.service;

import com.project.application.model.Job;

import java.util.List;

public interface JobService {

    Job save(Job job);

    Boolean delete(int id);

    Job update(Job task);

    Job findById(int id);

    List<Job> findAll();

}
