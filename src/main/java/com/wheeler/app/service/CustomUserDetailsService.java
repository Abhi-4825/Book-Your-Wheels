package com.wheeler.app.service;

import com.wheeler.app.model.AppUser;
import com.wheeler.app.repo.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user=userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("user not Found"));
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())// password here is encoded
                .roles(user.getRole())// is user admin or not
                .build();
    }
}
