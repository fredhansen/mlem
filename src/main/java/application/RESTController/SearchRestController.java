package application.RESTController;

import application.entities.Product;
import application.model.ProductSearch;
import application.repo.CategoryRepository;
import application.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchRestController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;



/*
    @PostMapping("/products/warehouse/search")
    public List<Product> showSearchResult(@RequestBody ProductSearch productSearch, Model model){
        List<Product> allProducts = productRepository.getAll();

        List<Product> result = new ArrayList<>();
        for (Product pr : allProducts){
            if (pr.toString().toLowerCase().contains(productSearch.getInput())){
                result.add(pr);
            }
        }
        model.addAttribute("products", result);
        return result;
    }

*/

}
