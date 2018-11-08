package application.controller;

import application.entities.ProductDTO;
import application.entities.UploadForm;
import application.repo.CategoryRepository;
import application.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
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
    private static String uploadFolder = System.getProperty("user.dir") +
            File.separator+"src"+
            File.separator+ "main"+
            File.separator+ "resources"+
            File.separator+"static"+
            File.separator+"img"+
            File.separator+"upload"+File.separator;
    {
        if (System.getProperty("os.name").contains("Linux")
            || System.getProperty("os.name").contains("Ubuntu")) {
            uploadFolder = "/app/src/main/resources/static/img/upload/";
        }
    }
    public Long randomLong() {

        return Math.abs(new Random().nextLong());
    }

    private final static String noImage = "/img/noImage.png";
    private final static String hasImage =  "/img/upload/";
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @PostMapping("products/add/save")
    public ProductDTO postProduct(@RequestBody ProductDTO productDTO) {

        System.out.println(productDTO.getImage());
        if (productDTO.getImage().equals("None")) {
            productDTO.setImage(noImage);
        } else {
            System.out.println(productDTO.getImage());
            productDTO.setImage(hasImage + productDTO.getImage().toLowerCase());
        }
        System.out.println(productDTO);
        productRepository.addProduct(randomLong(), productDTO.getName(), productDTO.getCategoryId(), productDTO.getTag(),
                productDTO.getDescription(), productDTO.getImage(), productDTO.getPrice(),
                productDTO.getAmount());


        return productDTO;
    }


    @PostMapping("products/add/image/save")
    public String postImage(@ModelAttribute UploadForm form) {

        if (form.getFile().isEmpty()) {
            System.out.println("none");
            return "None";
        }
        //System.out.println(form.getFile().getOriginalFilename());

        Path path = Paths.get(uploadFolder + form.getFile().getOriginalFilename().toLowerCase());
        try {
            byte[] bytes = form.getFile().getBytes();
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(form.getFile().getOriginalFilename());
        return form.getFile().getOriginalFilename().toLowerCase();
    }
}

