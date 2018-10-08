package application.controller;

import application.repo.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Field;
import java.util.List;


@Controller
public class StatisticsController {
    @Autowired
    private StatsRepository statsRepository;

    @RequestMapping("/stats")
    public String stats(Model model) {
        model.addAttribute("stats", statsRepository.findAll());
        model.addAttribute("statsCount", statsRepository.findCount());
        model.addAttribute("osCount", statsRepository.getOSstats()); // todo findos

        return "stats";
    }


}
