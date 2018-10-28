package application.repo;

import application.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> { // teeb automaatselt beani

    @Query(value = "SELECT * FROM users JOIN jobs_user ON users.Id = jobs_user.userId WHERE users.username = (:username)", nativeQuery = true)
    List<Object[]> getJobsBy(@Param("username") String username);

    @Query(value = "SELECT * FROM users WHERE users.username=(:username)", nativeQuery = true)
    User getUserByName(@Param("username") String username);


}
