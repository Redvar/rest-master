package rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import rest.models.User;
import rest.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final UserService userService;

    public RestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public ResponseEntity<User> getUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByUsername(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping("/getUsers")
    public List<User> listUsers() {
        return userService.findAll();
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        try {
            User user = userService.findById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public void create(@RequestBody User user) {
        userService.save(user);
    }


    @PutMapping("/edit")
    public ResponseEntity<User> edit(@RequestBody User user) {
        try {
            userService.update(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(userService.findById(id));
    }
}
