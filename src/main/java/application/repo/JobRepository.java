package application.repo;

import application.entities.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Integer> {

    //@Query(value = "SELECT ");

}
