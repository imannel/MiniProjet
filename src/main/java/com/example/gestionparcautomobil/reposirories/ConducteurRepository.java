package com.example.gestionparcautomobil.reposirories;

import com.example.gestionparcautomobil.entities.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ConducteurRepository extends JpaRepository<Conducteur,Long> {

    @Query("SELECT c FROM Conducteur c JOIN Voyage  v WHERE v.Date_Debut >= :dateFin OR v.Date_Fin <= :dateDebut")
    List<Conducteur> listConducteurDisponnible(@Param("dateFin") LocalDateTime dateFin , @Param("dateDebut") LocalDateTime dateDebut);

}
