package com.wheeler.app.service;

import com.wheeler.app.model.AppUser;
import com.wheeler.app.repo.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    private final PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private jwtUtil jwtUtil;
    public AppUserService(UserRepository userRepository, PasswordEncoder passwordEncoder, jwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }
    public void createNewUser(String name,String email,String password,String phone,String role){
        AppUser appUser = new AppUser();
        appUser.setName(name);
        appUser.setEmail(email);
        appUser.setPassword(passwordEncoder.encode(password));
        appUser.setPhone(phone);
        appUser.setRole(role);
        userRepository.save(appUser);
    }
    public AppUser getUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }


}
