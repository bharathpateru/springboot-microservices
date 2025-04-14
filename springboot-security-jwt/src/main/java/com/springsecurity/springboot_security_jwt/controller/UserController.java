package com.springsecurity.springboot_security_jwt.controller;

import com.springsecurity.springboot_security_jwt.model.Users;
import com.springsecurity.springboot_security_jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@RequestBody Users user){
        return service.registerUser(user);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<Users>> getAllUsers(){
        return service.getAllUsers();
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){

        return service.verify(user);
    }


}
