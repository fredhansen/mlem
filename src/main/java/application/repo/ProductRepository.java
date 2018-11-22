package application.repo;

import application.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT * FROM products WHERE category_Id=(?)", nativeQuery = true)
    List<Product> getAllByCategoryId(@Param("number") Long number);

    @Query(value = "SELECT * FROM products WHERE id=(:number)", nativeQuery = true)
    Product getById(@Param("number") String number);

    @Query(value="SELECT * FROM products", nativeQuery = true)
    List<Product> getAll();
    /*
    @Query(value="UPDATE product SET id=?, name=?, category_Id=?, ")
    */


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO products (id, name, category_Id, tag, description, image, price, amount) VALUES(?,?,?,?,?,?,?,?)", nativeQuery = true)
    void addProduct(@Param("id") Long id, @Param("name") String name, @Param("category_Id") Long category_Id, @Param("tag") String tag,
                    @Param("description") String description, @Param("image") String image, @Param("price") Double price, @Param("amount") Integer amount);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM products WHERE id=? ", nativeQuery = true )
    void deleteProductById(@Param("id") String id);



}

