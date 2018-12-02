package application.controller;

import application.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ShoppingCartController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/cart")

    public String cart(Model model) {

        model.addAttribute("products", productRepository.getAllProducts()); // todo allincart

        return "shoppingCart";
    }

}
