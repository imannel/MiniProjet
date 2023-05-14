package com.example.gestionparcautomobil.reposirories;

import com.example.gestionparcautomobil.entities.Vehicule;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule,String> {
    @Query("select v from Vehicule v where v.typeVehicule = :typevehicule")
    List<Vehicule> listVehiculeByType(@Param("typevehicule") String typevehicule);

    @Query("SELECT v2 FROM Vehicule v2 JOIN v2.voyages vg WHERE :dateDebut >= vg.Date_Fin AND :dateFin <= vg.Date_Debut")
    List<Vehicule> listVehiculeDisponnible(@Param("dateDebut") LocalDateTime dateDebut, @Param("dateFin") LocalDateTime dateFin);

}
