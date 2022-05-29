package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.models.Role;
import rest.repository.RoleDao;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public boolean existsByName(String roleName) {
        return roleDao.existsByName(roleName);
    }

    @Transactional
    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }

    @Transactional
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    @Transactional
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    @Transactional
    public void save(Role role) {
        roleDao.save(role);
    }
}
