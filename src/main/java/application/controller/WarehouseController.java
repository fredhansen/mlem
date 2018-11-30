package application.controller;

import application.entities.Category;
import application.entities.Product;
import application.model.ProductSearch;
import application.repo.CategoryRepository;
import application.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        if (productSearch.getWhatToSearch() == null){
            return "warehouse";
        }
        String search = productSearch.getInput().toLowerCase();
        if (productSearch.getWhatToSearch().equals("products")){
            List<Product> allProducts = productRepository.getAll();
            List<Product> result = new ArrayList<>();
            for (Product pr : allProducts){
                if ( pr.toJson().toLowerCase().contains(search)){
                    result.add(pr);
                }
            }
            System.out.println(productSearch.getInput());
            System.out.println(result);

            model.addAttribute("products", result);
            model.addAttribute("productsTable","true");
            return "warehouse";
        } else if (productSearch.getWhatToSearch().equals("category")) {
            List<Category> allCategories = categoryRepository.getAll();
            List<Category> result = new ArrayList<>();
            for (Category c : allCategories){
                if (c.toJson().toLowerCase().contains(search)){
                    result.add(c);
                }
            }

            System.out.println(productSearch.getInput());
            System.out.println(result);
            model.addAttribute("categories",result);
            model.addAttribute("categoriesTable","true");
            return "warehouse";
        }
        return "warehouse";
    }


}
