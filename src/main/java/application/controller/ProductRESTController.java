package application.controller;

import application.controller.model.AjaxProductResponse;
import application.dto.ProductDTO;
import application.entities.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRESTController {

    /**
     * Siia pange upload kausta tee
     */
    private static String uploadFolder = "C:\\Github\\Veebirakendusteloomine\\mlem\\src\\main\\resources\\static\\img\\upload\\";

    @GetMapping("/product/add/save")
    public AjaxProductResponse getProduct(){
        AjaxProductResponse ajaxProductResponse = new AjaxProductResponse("Done");

        return ajaxProductResponse;
    }

    @PostMapping("/product/add/save")
    public AjaxProductResponse postProduct(@RequestBody Product product){

        System.out.println(product);
        AjaxProductResponse ajaxProductResponse = new AjaxProductResponse("Done");
        return ajaxProductResponse;
    }


}
