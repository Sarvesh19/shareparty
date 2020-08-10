package com.shareparty.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shareparty.model.UserEntity;
import com.shareparty.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Optional<UserEntity> user = userRepo.findEmployeeByUserNameNative(username);
    	UserEntity userEntity= null;
    	if(user.isPresent()) {
    		userEntity = user.get();
    	}
        return new org.springframework.security.core.userdetails.User(userEntity.getEmail(), userEntity.getPassword(), new ArrayList<>());
    }
    
    
   
}