package com.example.gestionparcautomobil.services;

import com.example.gestionparcautomobil.Auth.AppRole;
import com.example.gestionparcautomobil.Auth.AppUser;

import java.util.List;

public interface UserService {
    AppUser addNewUser(AppUser appUser);






    List<AppUser> getUsers();


}
