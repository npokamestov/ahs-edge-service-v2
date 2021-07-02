package com.adhocsensei.ahsedgeservice.service;

import java.util.ArrayList;

import com.adhocsensei.ahsedgeservice.dao.UserRepository;
import com.adhocsensei.ahsedgeservice.dto.DAOUser;
import com.adhocsensei.ahsedgeservice.dto.UserDTO;
import com.adhocsensei.ahsedgeservice.service.AdHocSenseiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    AdHocSenseiService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DAOUser user = userRepo.findByUsername(username);
        if (user == null)  {
            throw new UsernameNotFoundException("DAOUser not found with email: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public DAOUser save(UserDTO user) {
            System.out.println("in user details service");
            System.out.println(user.toString());
        DAOUser newUser = new DAOUser();
            System.out.println(newUser);
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setBio(user.getBio());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setInstructor(user.isInstructor());
            System.out.println(newUser);
        return service.createUser(newUser);
    }
}
