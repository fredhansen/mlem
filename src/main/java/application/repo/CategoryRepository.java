package application.repo;

import org.springframework.data.repository.CrudRepository;
import application.entities.Category;


public interface CategoryRepository extends CrudRepository<Category, Long> {
}
