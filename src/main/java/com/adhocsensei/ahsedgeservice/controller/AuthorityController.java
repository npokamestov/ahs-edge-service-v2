package com.adhocsensei.ahsedgeservice.controller;

import com.adhocsensei.ahsedgeservice.dao.AuthorityRepository;
import com.adhocsensei.ahsedgeservice.dto.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorityController {

    @Autowired
    AuthorityRepository repo;

    @GetMapping("/authority")
    public List<Authority> getAllAuthorities() {
        return repo.findAll();
    }

    @GetMapping("/authority/{id}")
    public Optional<Authority> getAuthorityById(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping("/authority")
    public Authority createAuthority(@RequestBody Authority authority) {
        return repo.save(authority);
    }

    @PutMapping("/authority/{id}")
    public void updateAuthorityById(@PathVariable Long id, @RequestBody Authority authority) {
        Optional<Authority> optionalAuthority = repo.findById(id);
        if (optionalAuthority.isPresent()) {
            authority.setId(id);
            repo.save(authority);
        }
//        catch error and have appropriate response
    }

    @DeleteMapping("/authority/{id}")
    public void deleteAuthorityById(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
