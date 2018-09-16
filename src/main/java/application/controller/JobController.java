package application.controller;

import application.entities.Job;
import application.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/jobs")
public class JobController {
    @Autowired
    private JobRepository jobRepository;

    @GetMapping(path = "/add")
    public @ResponseBody
    String addnewjob(@RequestParam String username, @RequestParam String jobdescription) {

        Job newjob = new Job();
        newjob.setUsername(username);
        newjob.setJobdescription(jobdescription);
        jobRepository.save(newjob);
        return "Job added";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Job> getAllUsers() {
        return jobRepository.findAll();
    }


}
