package application.repo;

import application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Select * from tooted
    List<Product> findAll();
    List<Product> findAllByKategooriaId(Long number);
}
