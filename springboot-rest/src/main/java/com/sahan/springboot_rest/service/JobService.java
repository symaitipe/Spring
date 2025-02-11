package com.sahan.springboot_rest.service;


import com.sahan.springboot_rest.model.JobPost;
import com.sahan.springboot_rest.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    Repo repo;

    public void addJob(JobPost job){
        repo.addJob(job);
    }

    public List<JobPost> getAllJobs(){
       return repo.returnAllJobPosts();
    }

    public JobPost getJob(int jobId) {
        return repo.getJob(jobId);
    }

    public void updateJob(JobPost jobPost) {
        repo.updateJob(jobPost);
    }

    public void deleteJob(int jobId) {
        repo.deleteJob(jobId);
    }
}
