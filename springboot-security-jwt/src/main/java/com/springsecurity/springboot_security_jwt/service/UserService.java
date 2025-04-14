package com.springsecurity.springboot_security_jwt.service;

import com.springsecurity.springboot_security_jwt.model.Users;
import com.springsecurity.springboot_security_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    JwtService jwtService;


    public ResponseEntity<Users> registerUser(@RequestBody Users user) {
        Users users = null;
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            users = userRepository.save(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    public String verify(Users user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());

        return "Fail";
    }
}
