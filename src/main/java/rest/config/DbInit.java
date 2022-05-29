package rest.config;

import org.springframework.stereotype.Component;
import rest.models.Role;
import rest.models.User;
import rest.service.RoleService;
import rest.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class DbInit {

    private final UserService userService;
    private final RoleService roleService;

    public DbInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void createDefaultusers() {
        Set<Role> rolesadmin = new HashSet<>();
        Set<Role> rolesuser = new HashSet<>();
        roleService.save(new Role("ROLE_ADMIN"));
        roleService.save(new Role("ROLE_USER"));
        rolesadmin.add(roleService.getRoleById(1L));
        rolesuser.add(roleService.getRoleById(2L));

        User admin = new User("admin", "lastname", "admin", "1234", Collections.emptySet());
        admin.setRoles(rolesadmin);
        userService.save(admin);

        User user = new User("user", "lastname", "user", "1234", Collections.emptySet());
        user.setRoles(rolesuser);
        userService.save(user);
    }

}