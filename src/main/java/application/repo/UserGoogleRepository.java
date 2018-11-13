package application.repo;

import application.entities.User;
import application.entities.UserGoogle;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserGoogleRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM users_google WHERE email = (?)", nativeQuery = true)
    List<Object> getUserByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users_google (id, email) VALUES (?, ?)", nativeQuery = true)
    void addUser(@Param("id") Long id, @Param("email") String email);
}
