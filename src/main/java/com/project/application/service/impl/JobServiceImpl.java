package com.project.application.service.impl;

import com.project.application.model.Job;
import com.project.application.repository.JobRepository;
import com.project.application.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Boolean delete(int id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Job update(Job user) {
        return jobRepository.save(user);
    }

    @Override
    public Job findById(int id) {
        return jobRepository.findById(id).get();
    }

    @Override
    public List<Job> findAll(){return jobRepository.findAll();}


}
