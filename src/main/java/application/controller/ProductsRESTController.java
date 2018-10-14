package application.controller;
import application.entities.ProductDTO;
import application.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


@RestController
public class ProductsRESTController {

    /**
     * Siia pange upload kausta tee
     */
    private static String uploadFolder = "C:\\Github\\Veebirakendusteloomine\\mlem\\src\\main\\resources\\static\\img\\upload\\";

    private static Long randomLong(){

        return new Random().nextLong();
    }

    private static String noImage = "/img/noImage.png";
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("products/add/save")
    public ProductDTO postProduct(@RequestBody ProductDTO productDTO) {

        if (productDTO.getFileUpload() == null){
            productDTO.setImage(noImage);
        }
        System.out.println(productDTO);
        productRepository.addProduct(randomLong(),productDTO.getName(),1, productDTO.getTag(),
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

