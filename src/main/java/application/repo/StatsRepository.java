package application.repo;

import application.entities.Stats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StatsRepository extends CrudRepository<Stats, Integer> {

    @Query(value = "SELECT COUNT(*) FROM stats", nativeQuery = true)
    Integer findCount();

    @Query(value = "SELECT operating_System, COUNT(operating_System) as osc FROM stats GROUP BY operating_System DESC", nativeQuery = true)
    Iterable<Object[]> findOs(); //todo kuidagi vaja saada siit midagi


}

