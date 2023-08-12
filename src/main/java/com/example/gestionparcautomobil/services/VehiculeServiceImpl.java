package com.example.gestionparcautomobil.services;

import com.example.gestionparcautomobil.entities.Vehicule;
import com.example.gestionparcautomobil.exceptions.VehiculeNotFoundException;
import com.example.gestionparcautomobil.reposirories.VehiculeRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Builder
@Service


@Transactional
public class VehiculeServiceImpl implements VehiculeService {
    private VehiculeRepository vehiculeRepository;

    @Override
    public Vehicule saveVehicle(Vehicule vehicule) {
        return null;
    }

    @Override
    public List<Vehicule> listVehicule() {
        return null;
    }

    @Override
    public Vehicule getVehiculeById(String Matricule) throws VehiculeNotFoundException {
        return null;
    }

    @Override
    public List<Vehicule> listVehiculesByType(String TypeVehicule) {
       return vehiculeRepository.listVehiculeByType(TypeVehicule);

}

    @Override
    public List<Vehicule> listeVehiculesDisponibles(LocalDateTime dateDebut, LocalDateTime dateFin) {
        return vehiculeRepository.listVehiculeDisponnible(dateDebut,dateFin);
    }
}
