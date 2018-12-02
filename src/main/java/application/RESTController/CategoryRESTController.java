package application.RESTController;

import application.entities.Category;
import application.entities.CategoryDTO;
import application.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostRemove;
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
    public CategoryDTO postAddCategory(@RequestBody CategoryDTO categoryDTO) {
        System.out.println(categoryDTO);

        if (categoryDTO.getName() == null) {
            return null;
        }
        //categoryRepository.addCategory(randomLong(), categoryDTO.getName(),categoryDTO.getDescription());
        Category cat = new Category();
        cat.setId(randomLong());
        cat.setName(categoryDTO.getName());
        categoryRepository.save(cat);

        categoryDTO.setId(cat.getId());
        System.out.println(categoryDTO.getId());
        return categoryDTO;
    }

    @GetMapping("products/add/category/show")
    public List<Category> getCategory() {
        //System.out.println(categoryRepository.getAll());
        return categoryRepository.getAll();
    }


    @PostMapping("category/change/{id}/update")
    public String postChangeCategory(@PathVariable("id") String id,
                                          @RequestBody CategoryDTO categoryDTO){
        if (categoryDTO.getName().equals("")){
            return "None";
        }
        categoryRepository.changeCategory(categoryDTO.getName(),id);
        return "Done";
    }

    @PostMapping("category/delete/{id}")
    public String deleteCategory(@PathVariable("id") String id){
        Category checkProduct = categoryRepository.getById(id);
        if (checkProduct == null){
            return "None";
        }
        categoryRepository.deleteCategoryById(id);
        checkProduct = categoryRepository.getById(id);
        if (checkProduct == null){
            return "Success";
        }
        return "None";
    }
}
