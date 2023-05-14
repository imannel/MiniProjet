package com.example.gestionparcautomobil.web;

import com.example.gestionparcautomobil.Auth.AppRole;
import com.example.gestionparcautomobil.Auth.AppUser;
import com.example.gestionparcautomobil.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class UserRestController {
    private UserService userService;


    @GetMapping("/users")
    public List<AppUser> appUsers() {
        return userService.getUsers();
    }


    @PostMapping("/users")
    public AppUser saveUser(@RequestBody AppUser appUser) {
        return userService.addNewUser(appUser);
    }


    @Data
    class RoleUserForm {
        private String userName;
        private String roleName;
    }


}
