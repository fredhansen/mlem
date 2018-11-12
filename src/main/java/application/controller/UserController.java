package application.controller;

import application.entities.User;
import application.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/users") // http://159.65.205.181:8080/users (whitelabel)
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/adduser") // http://159.65.205.181:8080/users/adduser (whitelabel)
    public @ResponseBody
    String addNewUser(@RequestParam String username, @RequestParam String password) { // todo tuleb kontrollida, kas olemas juba selle usernameiga
        // http://159.65.205.181:8080/users/adduser?username=testuser1&password=testuser1 (saab lisada andmebaasi usereid)

        User newuser = new User();
        newuser.setUsername(username);
        newuser.setPassword(password);
        userRepository.save(newuser);
        return "User added";
    }

    @GetMapping(path = "/all")
    // http://159.65.205.181:8080/users/all (näitab kõiki usereid ja passworde, todo ilmselgelt ei ole ohutu)
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/byname")
    public @ResponseBody
    User getUser(@RequestParam String username) {
        return userRepository.getUserByName(username);
    }

    @GetMapping(path = "/jobsby")
    public @ResponseBody
    Iterable<Object[]> getJobsByUser(@RequestParam String username) {
        return userRepository.getJobsBy(username);
    }


}