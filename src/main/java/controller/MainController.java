package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/users") // localhost:8080/users (whitelabel)
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/adduser") // localhost:8080/users/adduser (whitelabel)
    public @ResponseBody
    String addNewUser(@RequestParam String username, @RequestParam String password) {
        // localhost:8080/users/adduser?username=testuser1&password=testuser1 (saab lisada andmebaasi usereid)

        User newuser = new User();
        newuser.setUsername(username);
        newuser.setPassword(password);
        userRepository.save(newuser);
        return "User added";
    }

    @GetMapping(path = "/all") // localhost:8080/users/all (näitab kõiki usereid ja passworde, ilmselgelt ei ole ohutu)
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}