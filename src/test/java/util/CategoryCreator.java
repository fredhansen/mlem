package util;

import application.entities.Category;

public class CategoryCreator {

    private Category category;

    public CategoryCreator() {
        this.category = new Category();
        this.category.setId(Any.randomLong());
        this.category.setName(Any.randomName());
    }

    public Category create(){
        return category;
    }

}
