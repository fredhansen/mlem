package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StatisticsController {

    @RequestMapping("/stats")
    public String products() {
        return "stats";
    }

}
