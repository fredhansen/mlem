package application.controller;

import application.controller.model.AjaxProductResponse;
import application.dto.ProductDTO;
import application.entities.Product;
import application.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class ProductRESTController {

    /**
     * Siia pange upload kausta tee
     */
    private static String uploadFolder = "C:\\Github\\Veebirakendusteloomine\\mlem\\src\\main\\resources\\static\\img\\upload\\";

    @Autowired
    private ProductRepository productRepository;



    @PostMapping("products/add/save")
    public ProductDTO postProduct(@RequestBody ProductDTO productDTO) {

        System.out.println(productDTO);
        productRepository.addProduct(productDTO.getName(),1, productDTO.getTag(),
                productDTO.getDescription(), productDTO.getImage(), productDTO.getPrice(),
                productDTO.getAmount());


        return productDTO;
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
