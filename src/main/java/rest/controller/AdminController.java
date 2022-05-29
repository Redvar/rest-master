package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rest.service.RoleService;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    RoleService roleService;

    @GetMapping("/user")
    public String getUserPage(){
        return "user";
    }


    @GetMapping("/admin")
    public String getAdminPage(Model model) {
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin";
    }
}

