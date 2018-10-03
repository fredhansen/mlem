package application.controller;

import application.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProductsController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @RequestMapping("/products")
    public String products() {
        return "products";
    }


    @RequestMapping(path = "/products/vac", method = RequestMethod.GET)
    public String showVacuum(Model model){
        model.addAttribute("products", productRepository.getAllByKategooriaId(1));
        return "products";
    }

    @RequestMapping(path = "/products/bags", method = RequestMethod.GET)
    public String showBags(Model model){
        model.addAttribute("products", productRepository.getAllByKategooriaId(2));
        return "products";
    }

    @RequestMapping(path = "/products/plastic", method = RequestMethod.GET)
    public String showPlastic(Model model){
        model.addAttribute("products", productRepository.getAllByKategooriaId(3));
        return "products";
    }










}
