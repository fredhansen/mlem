package application.controller;
import application.entities.ProductDTO;
import application.entities.UploadForm;
import application.repo.CategoryRepository;
import application.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;


@RestController
public class ProductsRESTController {

    /**
     * Siia pange upload kausta tee
     */
    private static String uploadFolder = "C:\\Github\\Veebirakendusteloomine\\mlem\\src\\main\\resources\\static\\img\\upload\\";

    public Long randomLong(){

        return Math.abs(new Random().nextLong());
    }

    private static String noImage = "/img/noImage.png";
    private static String hasImage ="/img/upload/";
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @PostMapping("products/add/save")
    public ProductDTO postProduct(@RequestBody ProductDTO productDTO) {

        System.out.println(productDTO.getImage());
        if (productDTO.getImage().equals("None")){
            productDTO.setImage(noImage);
        }
        else{

            productDTO.setImage(hasImage + productDTO.getImage());
        }
        System.out.println(productDTO);
        productRepository.addProduct(randomLong(),productDTO.getName(),productDTO.getCategoryId(), productDTO.getTag(),
                productDTO.getDescription(), productDTO.getImage(), productDTO.getPrice(),
                productDTO.getAmount());


        return productDTO;
    }


    @PostMapping("products/add/image/save")
    public String postImage(@ModelAttribute UploadForm form){

        if (form.getFile().isEmpty()){
            System.out.println("none");
            return "None";
        }
        //System.out.println(form.getFile().getOriginalFilename());

        Path path = Paths.get(uploadFolder + form.getFile().getOriginalFilename());
        try {
            byte[] bytes = form.getFile().getBytes();
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return form.getFile().getOriginalFilename();
    }
    /*
    @PostMapping("/save/image")
    public AjaxProductResponse postProductImage(@RequestParam("fileUpload") MultipartFile uploadFile){
        Path path = Paths.get(uploadFolder + uploadFile.getOriginalFilename());
        try {
            byte[] bytes = uploadFile.getBytes();
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        AjaxProductResponse ajaxProductResponse = new AjaxProductResponse(path.toString());
        return ajaxProductResponse;
    }
*/
}

