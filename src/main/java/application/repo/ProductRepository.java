package application.repo;

import application.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value="SELECT * FROM products WHERE category_Id=(:number)", nativeQuery = true)
    List<Product> getAllByCategoryId(@Param("number") int number);

}

