package application.RESTController;

import application.entities.Category;
import application.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class CategoryRESTController {

    @Autowired
    private CategoryRepository categoryRepository;

    public Long randomLong() {
        return Math.abs(new Random().nextLong());
    }

    @PostMapping("products/add/category/save")
    public String postAddCategory(@RequestBody Category category) {
        System.out.println(category);

        if (category.getName() == null) {
            return null;
        }
        //categoryRepository.addCategory(randomLong(), category.getName(),category.getDescription());
        Category cat = new Category();
        cat.setId(randomLong());
        cat.setName(category.getName());
        categoryRepository.save(cat);

        category.setId(cat.getId());
        System.out.println(category.getId());
        return category.toJson();
    }

    @GetMapping("products/add/category/show")
    public List<Category> getCategory() {
        //System.out.println(categoryRepository.getAll());
        return categoryRepository.getAll();
    }


    @PostMapping("category/change/{id}/update")
    public String postChangeCategory(@PathVariable("id") String id,
                                     @RequestBody Category category) {
        if (category.getName().equals("")) {
            return "None";
        }
        categoryRepository.changeCategory(category.getName(), id);
        return "Done";
    }

    @PostMapping("category/delete/{id}")
    public String deleteCategory(@PathVariable("id") String id) {
        Category checkProduct = categoryRepository.getById(id);
        if (checkProduct == null) {
            return "None";
        }
        categoryRepository.deleteCategoryById(id);
        checkProduct = categoryRepository.getById(id);
        if (checkProduct == null) {
            return "Success";
        }
        return "None";
    }
}
