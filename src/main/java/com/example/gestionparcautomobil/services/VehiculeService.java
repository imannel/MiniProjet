package com.example.gestionparcautomobil.services;

import com.example.gestionparcautomobil.entities.Vehicule;
import com.example.gestionparcautomobil.exceptions.VehiculeNotFoundException;

import java.util.List;
public interface VehiculeService {

    Vehicule saveVehicle(Vehicule vehicule);
    List<Vehicule> listVehicule();

    Vehicule getVehiculeById(String Matricule) throws VehiculeNotFoundException;

    List<Vehicule> listVehiculesByType(String TypeVehicule);

}
