package application.controller;

import application.entities.ProductDTO;
import application.entities.Product;
import application.entities.User;
import application.entities.UserGoogle;
import application.repo.CategoryRepository;
import application.repo.ProductRepository;
import application.repo.UserGoogleRepository;
import application.repo.UserRepository;
import application.services.EmailSendService;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserGoogleRepository userGoogleRepository;
    /**
     * Siia pange upload kausta tee
     */
    private static String uploadFolder = "C:\\Github\\Veebirakendusteloomine\\mlem\\src\\main\\resources\\static\\img\\upload\\";

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @RequestMapping("/products")
    public String products(Model model) throws IOException, MessagingException {
        model.addAttribute("categories", categoryRepository.getAll());
        return "products";
    }

    @GetMapping("/products/{id}")
    public String showCategory(@PathVariable("id") Long id, Model model) {
        model.addAttribute("categories", categoryRepository.getAll());

        for (Product pr : productRepository.getAllByCategoryId(id)) {
            System.out.println(pr);
            System.out.println(pr.getImage());
        }

        model.addAttribute("products", productRepository.getAllByCategoryId(id));
        return "products";
    }

    @GetMapping("/products/detail/{id}")
    public String showProductById(@PathVariable("id") String id, Model model) {
        model.addAttribute("categories", categoryRepository.getAll());

        System.out.println(id);
        Product product = productRepository.getById(id);
        System.out.println(product);
        model.addAttribute("products", product);
        return "productDetail";
    }

    /**
     * Product adding
     *
     * @param productDTO
     * @return
     */
    @GetMapping("/products/add")
    public String addProductHTML(ProductDTO productDTO) {
        return "productAdd";
    }

    @GetMapping("/products/change/{id}")
    public String changeProductHTML(@PathVariable("id") Long id) {
        return "productChange";
    }

}
