package com.springsecurity.springboot_security_jwt.service;

import com.springsecurity.springboot_security_jwt.model.Users;
import com.springsecurity.springboot_security_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if(user==null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Not Found With the Username:"+username);
        }

        return new UserPrincipal(user);
    }
}
