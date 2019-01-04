package application.repo;

import application.entities.FAQ;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface FAQRepository extends CrudRepository<FAQ, Long> {

    @Modifying
    @Transactional
    @Query(value="DELETE FROM faq WHERE faq_id=? ", nativeQuery = true )
    void deleteFAQById(@Param("id") String id);

}