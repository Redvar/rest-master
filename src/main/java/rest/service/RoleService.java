package rest.service;

import rest.models.Role;

import java.util.List;

public interface RoleService {
    boolean existsByName(String roleName);
    List<Role> getAllRoles();
    Role getRoleByName(String name);
    Role getRoleById(Long id);
    void save(Role role);


}
