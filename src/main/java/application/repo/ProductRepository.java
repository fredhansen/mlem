package application.repo;

import application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Select * from tooted
    List<Product> findAll();

    @Query(value="SELECT * FROM tooted WHERE kategooriaId=?1", nativeQuery = true)
    List<Product> getAllByKategooriaId(int number);

}

