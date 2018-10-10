package application.controller;

import application.entities.Product;
import application.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;


    public ProductsController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @RequestMapping("/products")
    public String products() {
        return "products";
    }


    @RequestMapping(path = "/products/vac", method = RequestMethod.GET)
    public String showVacuum(Model model){
        model.addAttribute("products", productRepository.getAllByCategoryId(1));
        return "products";
    }

    @RequestMapping(path = "/products/bags", method = RequestMethod.GET)
    public String showBags(Model model){
        model.addAttribute("products", productRepository.getAllByCategoryId(2));
        return "products";
    }

    @RequestMapping(path = "/products/plastic", method = RequestMethod.GET)
    public String showPlastic(Model model){
        model.addAttribute("products", productRepository.getAllByCategoryId(3));
        return "products";
    }

    @GetMapping("/products/detail/{id}")
    public String showProductById(@PathVariable("id") String id, Model model){
        System.out.println(id);
        List<Product> product = productRepository.getById(id);
        System.out.println(product);
        model.addAttribute("products", product);
        return "productDetail";
    }

    @GetMapping("/products/add")
    public String addProductHTML(Product product){
        return "productAdd";
    }

    @PostMapping("/products/add")
    public String addProductForm(@Valid Product product, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "productAdd";
        }
        productRepository.addProduct(product.getName(), product.getCategoryId(),product.getTag(),
                product.getDescription(), product.getImage(), product.getPrice(), product.getAmount());

        return "productAdd";
    }












}
