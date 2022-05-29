package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.models.User;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    boolean existsByUsername(String username);
    User findUserByUsername(String username);
}
