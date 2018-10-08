package application.repo;

import application.entities.Stats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatsRepository extends CrudRepository<Stats, Integer> {

    @Query(value = "SELECT COUNT(*) FROM stats", nativeQuery = true)
    Integer findCount();

    @Query(value = "SELECT operating_system as os, COUNT(operating_System) as osc FROM stats GROUP BY operating_System ORDER BY COUNT(operating_System) DESC", nativeQuery = true)
    List<Object> getOSstats();

}

