package application.controller;

import application.entities.Category;
import application.entities.CategoryDTO;
import application.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class CategoryRESTController {

    @Autowired
    private CategoryRepository categoryRepository;

    public Long randomLong(){
        return Math.abs(new Random().nextLong());
    }
    @PostMapping("products/add/category/save")
    public CategoryDTO postCategory(@RequestBody CategoryDTO categoryDTO){
        System.out.println(categoryDTO);

        if (categoryDTO.getName()== null){
            return null;
        }
        //categoryRepository.addCategory(randomLong(), categoryDTO.getName(),categoryDTO.getDescription());
        Category cat = new Category();
        cat.setId(randomLong());
        cat.setName(categoryDTO.getName());
        categoryRepository.save(cat);

//        categoryRepository.addCategory(randomLong(), categoryDTO.getName());

        categoryDTO.setId(cat.getId());

        return categoryDTO;
    }

    @GetMapping("products/add/category/show")
    public List<Category> getCategory(){
        //System.out.println(categoryRepository.getAll());
        return categoryRepository.getAll();
    }


}
