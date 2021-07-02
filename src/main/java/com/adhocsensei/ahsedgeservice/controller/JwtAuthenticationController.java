package com.adhocsensei.ahsedgeservice.controller;

import com.adhocsensei.ahsedgeservice.dto.JwtRequest;
import com.adhocsensei.ahsedgeservice.dto.JwtResponse;
import com.adhocsensei.ahsedgeservice.dto.UserDTO;
//import com.adhocsensei.ahsedgeservice.security.JwtConverter;
import com.adhocsensei.ahsedgeservice.security.JwtTokenUtil;
import com.adhocsensei.ahsedgeservice.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

//    private final JwtConverter converter;
//
//    public JwtAuthenticationController(AuthenticationManager authenticationManager, JwtConverter converter) {
//        this.authenticationManager = authenticationManager;
//        this.converter = converter;
//    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        System.out.println("in auth controller");
        System.out.println(user.toString());
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

//    @PostMapping("/refresh_token")
//    public ResponseEntity<Map<String, String>> refreshToken(UsernamePasswordAuthenticationToken principal) {
//        User user = new User(principal.getName(), principal.getName(), principal.getAuthorities());
//        String jwtToken = converter.getTokenFromUser(user);
//
//        HashMap<String, String> map = new HashMap<>();
//        map.put("jwt_token", jwtToken);
//
//        return new ResponseEntity<>(map, HttpStatus.OK);
//    }
}