package com.example.gestionparcautomobil.reposirories;


import com.example.gestionparcautomobil.Auth.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {

        Optional<AppUser> findByUsername(String username);
        Boolean existsByUsername(String username);
}
