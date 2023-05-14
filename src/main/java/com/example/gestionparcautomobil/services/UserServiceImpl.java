package com.example.gestionparcautomobil.services;

import com.example.gestionparcautomobil.Auth.AppRole;
import com.example.gestionparcautomobil.Auth.AppUser;

import com.example.gestionparcautomobil.reposirories.AppUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    @Transactional
    public class UserServiceImpl implements UserService {
        @Autowired
        private AppUserRepository appUserRepository;

        @Override
        public AppUser addNewUser(AppUser appUser) {
        return appUserRepository.save(appUser);

        }


        //@Override
        //public void addRoleToUser(String userName, String roleName) {
        //AppUser appUser = appUserRepository.findByUsername(userName);
    //AppRole appRole = appRoleRepository.findByRoleName(roleName);
    //appUser.getAppRole().add(appRole);
    // }


            @Override
        public List<AppUser> getUsers(){
            return appUserRepository.findAll();
            }

        }


