package com.wheeler.app.controller;

import com.wheeler.app.model.AppUser;
import com.wheeler.app.service.AppUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {
    private AppUserService service;
    public AppUserController(AppUserService service) {
        this.service = service;
    }
    @PostMapping("createAccount")
    public void createAccount(@RequestBody AppUser user) {
        service.createNewUser(user.getName(), user.getEmail(), user.getPassword(), user.getPhone(),  user.getRole());
    }


}
