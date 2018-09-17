package application.controller;

import application.entities.Job;
import application.entities.User;
import application.repo.JobRepository;
import application.repo.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/add")
    public @ResponseBody
    String addnewjob(@RequestParam String username, @RequestParam String jobdescription) {

        User user = userRepository.getUserByName(username);

        Job newjob = new Job();
        newjob.setUser(user);
        newjob.setJobdescription(jobdescription);
        jobRepository.save(newjob);
        return "Job added";
    }

    @GetMapping(path = "/all") // todo hetkel annab errori
    public @ResponseBody
    Iterable<Job> getAllUsers() {
        return jobRepository.findAll();
    }


}
