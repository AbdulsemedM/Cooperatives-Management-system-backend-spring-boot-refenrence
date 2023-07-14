package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.Job;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.repositories.JobRepository;
import com.dxvalley.project.services.JobService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    @Autowired
    private final JobRepository jobRepository;


    @Override
    public Job addJob(Job job) {
       return jobRepository.save(job);
        
    }

    @Override
    public Job editJob(Job job) {
       return jobRepository.save(job);
    }

    @Override
    public List<Job> getJobs() {
        
       return  jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long jobId) {
        return jobRepository.findJobByJobId(jobId);
    }


    @Override
    public List<Job> getJobByUnion(Unions union) {
        return jobRepository.findJobByUnion(union);
    }

    @Override
    public List<Job> getJobByPrCooperative(PrCooperative prCooperative) {
      return jobRepository.findJobByPrCooperative(prCooperative);
    }

    @Override
    public void deleteJob(Long jobId) {
       jobRepository.deleteById(jobId);
    }

    @Override
    public Job getJobByJobTitle(String jobTitle) {
       return jobRepository.findJobByJobTitle(jobTitle);
    }
    

}
