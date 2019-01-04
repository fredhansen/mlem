package application.RESTController;

import application.entities.FAQ;
import application.repo.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FAQRESTController {

    @Autowired
    private FAQRepository faqRepository;


    @PostMapping("faq/save")
    public FAQ postFAQ(@RequestBody FAQ faq) {

        faqRepository.save(faq);
        System.out.println("faqREST: " + faq);

        return faq;
    }

    @PostMapping("faq/delete/{id}")
    public String deleteFAQ(@PathVariable("id") String id) {

        System.out.println("Delete FAQ id: " + id);
        faqRepository.deleteFAQById(id);


        return "FAQ deleted";
    }
}
