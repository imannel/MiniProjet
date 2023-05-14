package com.example.gestionparcautomobil.services;

import com.example.gestionparcautomobil.entities.Conducteur;
import com.example.gestionparcautomobil.entities.Vehicule;
import com.example.gestionparcautomobil.entities.Voyage;
import com.example.gestionparcautomobil.exceptions.*;

import java.time.LocalDateTime;

public interface VoyageService {

    Voyage saveVoyage(Voyage voyage);
    Voyage PlanifierVoyage(LocalDateTime Date_Debut, LocalDateTime Date_Fin , String TypeVehicule);
    Voyage AffectationConducteur(long voyageId,long conducteurId)throws ConducteurNotFoundException, ConducteurNonDisponibleException , VoyageNotFoundException;
    Voyage AffectationVehicule(long voyageId ,String matricule)throws VehiculeNotFoundException, VehiculeNonDisponibleException,VoyageNotFoundException;

    Voyage getVoyage(Long id)throws VoyageNotFoundException;
}
