package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ShoppingCartController {

    @RequestMapping("/cart")
    public String cart() {
        return "shoppingCart";
    }

}
