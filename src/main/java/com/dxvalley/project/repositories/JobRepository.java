package com.dxvalley.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Job;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface JobRepository extends JpaRepository<Job, Long> {
    Job findJobByJobId (Long jobId);
    Job findJobByJobTitle(String jobTitle);
    Job findJobByEmployeeNumber( Integer employeeNumber);  
    List<Job> findJobByUnion(Unions union);  
    List<Job> findJobByPrCooperative(PrCooperative prCooperative);
}
