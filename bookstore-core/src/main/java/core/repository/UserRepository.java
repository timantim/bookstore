package core.repository;

import core.model.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends BookstoreRepository<User, Long> {
    @Query("SELECT u from User u WHERE u.username=?1")
    User getUserByUsername(String username);
}
