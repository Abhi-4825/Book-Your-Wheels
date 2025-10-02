package com.wheeler.app.service;

import com.wheeler.app.model.AppUser;
import com.wheeler.app.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    private final PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    public AppUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
}
