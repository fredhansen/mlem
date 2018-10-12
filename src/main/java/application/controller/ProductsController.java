package application.controller;

import application.dto.ProductDTO;
import application.entities.Product;
import application.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Controller
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;
    /**
     * Siia pange upload kausta tee
     */
    private static String uploadFolder = "C:\\Github\\Veebirakendusteloomine\\mlem\\src\\main\\resources\\static\\img\\upload\\";

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

    /**
     * Product adding
     * @param productDTO
     * @return
     */
    @GetMapping("/products/add")
    public String addProductHTML(ProductDTO productDTO){
        return "productAdd2";
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
