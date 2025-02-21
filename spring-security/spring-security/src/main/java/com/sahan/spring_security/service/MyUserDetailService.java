package com.sahan.spring_security.service;

import com.sahan.spring_security.model.User;
import com.sahan.spring_security.model.UserPrincipal;
import com.sahan.spring_security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        User user = userRepo.findByUsername(username);

        if(user==null){
            System.out.println("User Not Found 404");
            throw new UsernameNotFoundException("User Not Found 404");
        }
        return new UserPrincipal(user);
    }
}
