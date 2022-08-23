package com.java.timesheet.service;
import java.util.ArrayList;

import com.java.timesheet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.java.timesheet.model.User user = userRepository.findByEmail(username);
        if (user == null ) {
            throw new UsernameNotFoundException("User not found with username: " + username);

        } else {
            return new User(user.getEmail(),
                    user.getPassword(),
                    new ArrayList<>()
                    );}
    }

}