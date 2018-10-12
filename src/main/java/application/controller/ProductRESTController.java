package application.controller;

import application.controller.model.AjaxProductResponse;
import application.dto.ProductDTO;
import application.entities.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/add")
public class ProductRESTController {

    /**
     * Siia pange upload kausta tee
     */
    private static String uploadFolder = "C:\\Github\\Veebirakendusteloomine\\mlem\\src\\main\\resources\\static\\img\\upload\\";
/*
    @GetMapping("/product/add/save")
    public AjaxProductResponse getProduct(){
        AjaxProductResponse ajaxProductResponse = new AjaxProductResponse("Done");

        return ajaxProductResponse;
    }
    */

    @PostMapping("/save")
    public AjaxProductResponse postProduct(@RequestBody ProductDTO productDTO){

        System.out.println(productDTO);
        AjaxProductResponse ajaxProductResponse = new AjaxProductResponse("Done");
        return ajaxProductResponse;
    }


}
