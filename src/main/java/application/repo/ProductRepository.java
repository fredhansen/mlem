package application.repo;

import application.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value="SELECT * FROM products WHERE category_Id=(:number)", nativeQuery = true)
    List<Product> getAllByCategoryId(@Param("number") int number);

    @Query(value="SELECT * FROM products WHERE id=(:number)", nativeQuery = true)
    List<Product> getById(@Param("number") String number);


    @Modifying
    @Transactional
    @Query(value="INSERT INTO products (name, category_Id, tag, description, image, price, amount) values(?,?,?,?,?,?,?)", nativeQuery = true)
    void addProduct(@Param("name") String name, @Param("category_Id") Integer category_Id, @Param("tag") String tag,
                    @Param("description") String description, @Param("image") String image, @Param("price") Double price, @Param("amount") Integer amount);

}

