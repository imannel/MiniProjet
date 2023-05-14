package com.example.gestionparcautomobil.services;

import com.example.gestionparcautomobil.dtos.ConducteurDTO;
import com.example.gestionparcautomobil.entities.Conducteur;
import com.example.gestionparcautomobil.entities.Permis;
import com.example.gestionparcautomobil.entities.Vehicule;
import com.example.gestionparcautomobil.enums.TypePermis;
import com.example.gestionparcautomobil.exceptions.ConducteurNotFoundException;

import java.time.LocalDateTime;

import java.util.List;

public interface ConducteurService {
    ConducteurDTO saveConducteur(ConducteurDTO conducteur);
    public void deleteConducteur(Long conducteurId);
    Permis savePermis(long conducteurId,TypePermis type,LocalDateTime dateExp) throws ConducteurNotFoundException;


    List<Permis> listPermis(long conducteurId);
    List<ConducteurDTO> listConducteur();
    ConducteurDTO getConducteur(Long id) throws ConducteurNotFoundException;
    List<Conducteur> listConducteurDisponnible(LocalDateTime dateDebut, LocalDateTime dateFin);
    boolean peutConduireTypeVehicule(Conducteur conducteur, String typeVehicule) ;

}
