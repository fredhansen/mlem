package util;

import application.entities.Category;
import application.entities.Product;

import java.io.IOException;

public class ProductCreator {

    private Product product;

    public ProductCreator(Category category) throws IOException {
        this.product = new Product();
        this.product.setId(Any.randomLong());
        this.product.setName(Any.randomName());
        this.product.setCategoryId(category.getId());
        this.product.setTag(Any.randomName());
        this.product.setDescription(Any.randomName());
        this.product.setImage(Any.randomImage());
        this.product.setPrice(Any.randomDouble());
        this.product.setAmount(Any.randomInt());
    }

    public Product create(){
        return product;
    }


}
