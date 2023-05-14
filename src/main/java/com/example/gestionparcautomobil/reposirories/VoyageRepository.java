package com.example.gestionparcautomobil.reposirories;

import com.example.gestionparcautomobil.entities.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoyageRepository extends JpaRepository<Voyage,Long> {

}
