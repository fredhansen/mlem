package application.controller;

import application.repo.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FAQController {

    @Autowired
    private FAQRepository faqRepository;

    @RequestMapping("/faq")
    public String faq(Model model) {

        model.addAttribute("faqs", faqRepository.findAll());

        return "faq";
    }

}
