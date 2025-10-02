package com.wheeler.app.service;

import com.wheeler.app.model.AppUser;
import com.wheeler.app.repo.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user=userRepository.findByName(username)
                .orElseThrow(()->new UsernameNotFoundException("user not Found"));
        return User.builder()
                .username(user.getName())
                .password(user.getPassword())// password here is encoded
                .roles(user.getRole())// is user admin or not
                .build();
    }
}
