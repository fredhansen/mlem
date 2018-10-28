package application.repo;

import application.entities.Stats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatsRepository extends CrudRepository<Stats, Integer> {

    @Query(value = "SELECT COUNT(*) FROM stats", nativeQuery = true)
    Integer findCount();

    @Query(value = "SELECT operating_system AS os, COUNT(operating_System) AS osc FROM stats GROUP BY operating_System ORDER BY COUNT(operating_System) DESC", nativeQuery = true)
    List<Object> getOSstats();

    @Query(value = "SELECT browser, COUNT(browser) FROM stats GROUP BY browser ORDER BY COUNT(browser) DESC", nativeQuery = true)
    List<Object> getBrowserStats();

    @Query(value = "SELECT device_type, COUNT(device_type) FROM stats GROUP BY device_type ORDER BY COUNT(device_type) DESC", nativeQuery = true)
    List<Object> getDeviceStats();

}

