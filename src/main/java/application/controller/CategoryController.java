package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {


    @GetMapping("/category/change/{id}")
    public String changeCategory(@PathVariable("id") String id){
        return "categoryChange";
    }

}
