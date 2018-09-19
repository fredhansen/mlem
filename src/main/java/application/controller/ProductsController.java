package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ProductsController {

    @RequestMapping("/products")
    public String products() {
        return "products";
    }

}
