package com.wheeler.app.controller;

import com.wheeler.app.model.AppUser;
import com.wheeler.app.model.LoginRequest;
import com.wheeler.app.service.AppUserService;
import com.wheeler.app.service.jwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppUserController {
    private jwtUtil jwtUtil;
    private AuthenticationManager  authenticationManager;
    private AppUserService service;
    public AppUserController(AppUserService service, jwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.service = service;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }
    @PostMapping("/createAccount")
    public void createAccount(@RequestBody AppUser user) {
        service.createNewUser(user.getName(), user.getEmail(), user.getPassword(), user.getPhone(),  user.getRole());
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        System.out.println("jwt is being called");
        // authenticate using AuthenticationManager
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // if successful, generate JWT
        if(authentication.isAuthenticated()) {
            AppUser user=service.getUserByEmail(request.getEmail());
            System.out.println(user.getEmail());
        String t=jwtUtil.generateJwtToken(user);System.out.println(t);
        return t;
            }
        else {
            throw  new UsernameNotFoundException("Invalid Username or Password");
        }


    }



}
