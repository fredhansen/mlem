package application.controller;

import application.repo.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StatisticsController {
    @Autowired
    private StatsRepository statsRepository;

    @RequestMapping("/stats")
    public String stats(Model model) {
        model.addAttribute("stats", statsRepository.findAll());
        return "stats";
    }


}
