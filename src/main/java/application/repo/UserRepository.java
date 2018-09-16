package application.repo;

import application.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> { // teeb automaatselt beani

}
