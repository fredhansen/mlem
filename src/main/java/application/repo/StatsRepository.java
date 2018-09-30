package application.repo;

import application.entities.Stats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StatsRepository extends CrudRepository<Stats, Integer> {

    @Query(value = "SELECT COUNT(*) FROM stats", nativeQuery = true)
    Integer findCount();


}

