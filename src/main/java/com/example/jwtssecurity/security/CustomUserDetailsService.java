package com.example.jwtssecurity.security;

import com.example.jwtssecurity.model.User;
import com.example.jwtssecurity.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found!"));
       return UserPrincipal.create(user); 
    }

    public UserDetails loadUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(
        () -> new UsernameNotFoundException("User not found with id " + id) );

        return UserPrincipal.create(user);
    }

}
