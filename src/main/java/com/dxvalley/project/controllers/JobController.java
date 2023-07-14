package com.dxvalley.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxvalley.project.models.CreateResponse;
import com.dxvalley.project.models.Job;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.services.JobService;
import com.dxvalley.project.services.PrCooperativeService;
import com.dxvalley.project.services.UnionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/job")
//@ComponentScan({"com.dxvalley.project.services.JobService.rest_Controllers"})
public class JobController {
    @Autowired
    private final JobService jobService;
    private final UnionService unionnService;
    private final PrCooperativeService prCoopperativeService;

    @GetMapping("/getjobs")
    List<Job> getJob() {
    return this.jobService.getJobs();
  }

  @GetMapping("/{jobId}")
  Job getJob(@PathVariable Long jobId) {
    return jobService.getJobById(jobId); 
  }

  @GetMapping("/getByUnionId/{unionId}")
  List<Job> getJobByUnionId(@PathVariable Long unionId) {
  Unions  union=unionnService.getUnionById(unionId); 
  return jobService.getJobByUnion(union);
}

@GetMapping("/getByprCooperativeId/{prCooperativeId}")
List<Job> getJobByPrCooperativeId(@PathVariable Long prCooperativeId)  {
PrCooperative prCooperative = prCoopperativeService.getPrCooperativeById(prCooperativeId);
return jobService.getJobByPrCooperative(prCooperative);
}

  @PostMapping("/add")
  public ResponseEntity<CreateResponse> addJob (@RequestBody Job job) {
    Job jobToBeChecked= jobService.getJobByJobTitle(job.getJobTitle()); 
    if(jobToBeChecked!=null)
    {
        CreateResponse response = new CreateResponse("error","existing job name");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    else
    {
        jobService.addJob(job);
        CreateResponse response = new CreateResponse("success","job created successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

  }

  @PutMapping("/edit/{jobId}")
  Job editJob(@RequestBody Job tempJob, @PathVariable Long jobId) {
    Job job = this.jobService.getJobById(jobId);
    job.setJobTitle(tempJob.getJobTitle());  
    job.setDateCreated(tempJob.getDateCreated());
    job.setEmployeeNumber(tempJob.getEmployeeNumber());
    job.setPrCooperative(tempJob.getPrCooperative());
    job.setUnion(tempJob.getUnion());
     
    return jobService.editJob(job);
    
  }
}
