package application.repo;

import application.entities.FAQ;
import org.springframework.data.repository.CrudRepository;


public interface FAQRepository extends CrudRepository<FAQ, Long> {


}