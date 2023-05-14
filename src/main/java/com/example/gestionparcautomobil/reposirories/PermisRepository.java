package com.example.gestionparcautomobil.reposirories;

import com.example.gestionparcautomobil.entities.Permis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisRepository extends JpaRepository<Permis,String> {
}
