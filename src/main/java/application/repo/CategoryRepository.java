package application.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import application.entities.Category;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Modifying
    @Transactional
    @Query(value="INSERT INTO category (id, name, description) values(?,?,?)", nativeQuery = true)
    void addCategory(@Param("id") Long id, @Param("name") String name, @Param("description") String description);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO category (id, name) values(?,?)", nativeQuery = true)
    void addCategory(@Param("id") Long id, @Param("name") String name);



    @Query(value="SELECT id, name from category", nativeQuery = true)
    List<Category> getAll();
}
