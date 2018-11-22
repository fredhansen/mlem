package application.controller;

import application.entities.Product;
import application.model.ProductSearch;
import application.repo.CategoryRepository;
import application.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WarehouseController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/products/warehouse")
    public String showWarehouse(ProductSearch productSearch,
                                Model model){
        return "warehouse";
    }

    @PostMapping("/products/warehouse/search")
    public String showSearchResult(ProductSearch productSearch, Model model){
        List<Product> allProducts = productRepository.getAll();

        List<Product> result = new ArrayList<>();
        for (Product pr : allProducts){
            if (pr.toString().toLowerCase().contains(productSearch.getInput())){
                result.add(pr);
            }
        }
        System.out.println(productSearch.getInput());
        System.out.println(result);
        model.addAttribute("products", result);
        return "warehouse";
    }
}
