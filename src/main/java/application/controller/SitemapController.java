package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SitemapController {

    @RequestMapping("/sitemap")
    public String products() {
        return "sitemap";
    }

}
