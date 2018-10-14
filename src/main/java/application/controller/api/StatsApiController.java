package application.controller.api;

import application.repo.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/api/stats")
public class StatsApiController {

    @Autowired
    private StatsRepository statsRepository;

    @GetMapping("/os")
    @ResponseBody
    public List<Object> getOS() {
        return statsRepository.getOSstats();
    }



}
