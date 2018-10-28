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
    public String products(Model model, Principal principal) throws IOException, MessagingException {
        // Getting info if user is logged
        if (principal != null) {
            OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
            Authentication authentication = oAuth2Authentication.getUserAuthentication();
            Map<String, String> details = (Map<String, String>) authentication.getDetails();
            Map<String, String> map = new LinkedHashMap<>();
            map.put("email", details.get("email"));
            System.out.println(map.get("email"));
            List<Object> userGoogle = userGoogleRepository.getUserByEmail(map.get("email"));
            // If user loggs for the first time we add him to DB
            if (userGoogle.isEmpty()) {
                userGoogleRepository.addUser(1L, map.get("email"));
                EmailSendService.sendMail(map.get("email"));
            }
        }
        model.addAttribute("categories", categoryRepository.getAll());
        return "products";
    }
/*
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
*/

    @GetMapping("/products/{id}")
    public String showCategory(@PathVariable("id") Long id, Model model) {
        model.addAttribute("categories", categoryRepository.getAll());

        for (Product pr : productRepository.getAllByCategoryId(id)) {
            System.out.println(pr);
        }
        model.addAttribute("products", productRepository.getAllByCategoryId(id));
        return "products";
    }

    @GetMapping("/products/detail/{id}")
    public String showProductById(@PathVariable("id") String id, Model model) {
        model.addAttribute("categories", categoryRepository.getAll());

        System.out.println(id);
        List<Product> product = productRepository.getById(id);
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
/*
    @PostMapping("/product/add")
    public String addProductForm(@Valid ProductDTO productDTO, BindingResult bindingResultDTO, RedirectAttributes redirectAttributes,
            @RequestParam("file") MultipartFile file){

        System.out.println(productDTO);
        if(bindingResultDTO.hasErrors()){
            return "productAdd";
        }
        Path path = Paths.get(uploadFolder + file.getOriginalFilename());

        try {
            byte[] bytes = file.getBytes();
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("confirm", "File uploaded'" +file.getOriginalFilename()+"'");
        } catch (IOException e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("confirm", "Registreering ok");
        productRepository.addProduct(productDTO.getName(),1, productDTO.getTag(),
                productDTO.getDescription(),path.toString(), productDTO.getPrice(),
                productDTO.getAmount());



        return "productAdd";
    }
*/

}
