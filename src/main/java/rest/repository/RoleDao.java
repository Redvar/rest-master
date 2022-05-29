package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.models.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    Role getRoleByName(String name);
    boolean existsByName(String roleName);
    Role getRoleById(Long id);
}
