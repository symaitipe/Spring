package com.sahan.springboot_rest;

import com.sahan.springboot_rest.model.JobPost;
import com.sahan.springboot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    JobService service;

    @GetMapping("jobPosts")
    //ResponseBody --we can use @Rescontroller instead of use @ResponseBody where we not need to return an HTML page but instead send raw data (like text or JSON) in the response.
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("/jobPost/{jobId}")
    public JobPost getJob(@PathVariable("jobId") int jobId) {
        return service.getJob(jobId);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobpost){
        try{
            service.addJob(jobpost);
            System.out.println("Added success");
        }catch (Exception ex){
            System.out.println("Eror is : "+ex);
        }
    }

    @PutMapping("jobPost")
    public void updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId)
    {
        service.deleteJob(postId);
        return "Deleted";
    }
}
