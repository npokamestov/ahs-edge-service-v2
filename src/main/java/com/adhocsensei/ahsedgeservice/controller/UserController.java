//package com.adhocsensei.ahsedgeservice.controller;
//
//import com.adhocsensei.ahsedgeservice.dao.UserRepository;
//import com.adhocsensei.ahsedgeservice.dto.DAOUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class UserController {
//
//    @Autowired
//    UserRepository repo;
//
//    @GetMapping("/user")
//    public List<DAOUser> getAllUsers() {
//        return repo.findAll();
//    }
//
//    @GetMapping("/user/{id}")
//    public Optional<DAOUser> getUserById(@PathVariable Long id) {
//        return repo.findById(id);
//    }
//
//    @PostMapping("/user")
//    public DAOUser createUser(@RequestBody DAOUser user) {
//        System.out.println("creating user in user controller");
//
//        return repo.save(user);
//    }
//
//    @PutMapping("/user/{id}")
//    public void updateUserById(@PathVariable Long id, @RequestBody DAOUser user) {
//        Optional<DAOUser> optionalUser = repo.findById(id);
//        if (optionalUser.isPresent()) {
//            user.setId(id);
//            repo.save(user);
//        }
////        catch error and have appropriate response
//    }
//
//    @DeleteMapping("/user/{id}")
//    public void deleteUserById(@PathVariable Long id) {
//        repo.deleteById(id);
//    }
//}
