package com.project.application.service.impl;

import com.project.application.model.Applicant;
import com.project.application.model.Job;
import com.project.application.repository.ApplicantRepository;
import com.project.application.repository.JobRepository;
import com.project.application.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public Applicant save(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    @Override
    public Boolean delete(int id) {
        if (applicantRepository.existsById(id)) {
            applicantRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Applicant update(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    @Override
    public Applicant findById(int id) {
        return applicantRepository.findById(id).get();
    }

    @Override
    public List<Applicant> findAll(){return applicantRepository.findAll();}

    @Override
    public List<Applicant> findAllByJob(Job job) {
        return applicantRepository.findAllByJob(job);
    }
}
