package application.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import application.entities.Category;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO category (id, name, description) VALUES(?,?,?)", nativeQuery = true)
    void addCategory(@Param("id") Long id, @Param("name") String name, @Param("description") String description);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO category (id, name) VALUES(?,?)", nativeQuery = true)
    Category addCategory(@Param("id") Long id, @Param("name") String name);

    @Query(value = "SELECT id, name FROM category", nativeQuery = true)
    List<Category> getAll();

    @Query(value = "Select * FROM category WHERE id=?", nativeQuery = true)
    Category getById(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value= "UPDATE category SET name=? WHERE id=?", nativeQuery = true)
    void changeCategory(@Param("name") String name,
                       @Param("id") String id);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM category WHERE id=? ", nativeQuery = true )
    void deleteCategoryById(@Param("id") String id);
}
