package com.adhocsensei.ahsedgeservice.controller;

import com.adhocsensei.ahsedgeservice.dao.UserRepository;
import com.adhocsensei.ahsedgeservice.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository repo;

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping("/user")
    public User createAUser(@RequestBody User user) {
        return repo.save(user);
    }

    @PutMapping("/user/{id}")
    public void updateUserById(@PathVariable Long id, @RequestBody User user) {
        Optional<User> optionalUser = repo.findById(id);
        if (optionalUser.isPresent()) {
            user.setId(id);
            repo.save(user);
        }
//        catch error and have appropriate response
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
