package application.controller;

import application.controller.dto.ProductDTO;
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

    @GetMapping("/product/add")
    public String addProductHTML(ProductDTO productDTO){
        return "productAdd";
    }

    @PostMapping("/product/add")
    public String addProductForm(@Valid ProductDTO productDTO, BindingResult bindingResultDTO){

        System.out.println(productDTO);
        if(bindingResultDTO.hasErrors()){
            return "productAdd";
        }


        productRepository.addProduct(productDTO.getName(),1, productDTO.getTag(),
                productDTO.getDescription(),"/src/mingiKaust", productDTO.getPrice(),
                productDTO.getAmount());



        return "productAdd";
    }












}
