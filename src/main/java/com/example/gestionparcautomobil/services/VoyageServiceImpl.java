package com.example.gestionparcautomobil.services;

import com.example.gestionparcautomobil.entities.Conducteur;
import com.example.gestionparcautomobil.entities.Vehicule;
import com.example.gestionparcautomobil.entities.Voyage;
import com.example.gestionparcautomobil.exceptions.*;
import com.example.gestionparcautomobil.reposirories.ConducteurRepository;
import com.example.gestionparcautomobil.reposirories.VehiculeRepository;
import com.example.gestionparcautomobil.reposirories.VoyageRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
@Transactional
public class VoyageServiceImpl implements VoyageService {
    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Autowired
    private VoyageRepository voyageRepository;
    @Autowired
    private ConducteurRepository conducteurRepository;
    @Autowired
    private ConducteurService conducteurService;
    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public Voyage saveVoyage(Voyage voyage) {
        log.info("saving new Voyage");
        Voyage savedVoyage = voyageRepository.save(voyage);
        return savedVoyage;
    }

    @Override
    public Voyage PlanifierVoyage(LocalDateTime Date_Debut, LocalDateTime Date_Fin, String TypeVehicule) {
        Voyage voyage = Voyage.builder()
                .typeVehicule(TypeVehicule)
                .Date_Debut(Date_Debut)
                .Date_Fin(Date_Fin)
                .build();

        return voyage;
    }

    @Override
    public Voyage AffectationConducteur(long voyageId, long conducteurId) throws ConducteurNotFoundException, ConducteurNonDisponibleException , VoyageNotFoundException {
        Conducteur conducteur = conducteurRepository.findById(conducteurId).orElseThrow(() -> new ConducteurNotFoundException("conducteur not found"));
        Voyage voyage = voyageRepository.findById(voyageId).orElseThrow(() -> new VoyageNotFoundException("Voyage not exist"));
        if (conducteurRepository.listConducteurDisponnible(voyage.getDate_Debut(), voyage.getDate_Fin()).contains(conducteur) && conducteurService.peutConduireTypeVehicule(conducteur, voyage.getTypeVehicule())
        ) {
            voyage.setConducteur(conducteur);
            return voyage;
        } else if (!conducteurService.peutConduireTypeVehicule(conducteur, voyage.getTypeVehicule())) {
            throw new ConducteurNonDisponibleException("Conducteur ne peut pas conduire ce type de véhicule. ");
        } else
            throw new ConducteurNonDisponibleException("Conducteur n'est pas disponible");

    }



    @Override
    public Voyage AffectationVehicule(long voyageId, String matricule)throws VehiculeNotFoundException, VehiculeNonDisponibleException,VoyageNotFoundException {
        Vehicule vehicule = vehiculeRepository.findById(matricule).orElseThrow(() ->new VehiculeNotFoundException("vehicule not found"));
        Voyage voyage = voyageRepository.findById(voyageId).orElseThrow(() -> new VoyageNotFoundException("Voyage not exist"));
        if (vehiculeRepository.listVehiculeDisponnible(voyage.getDate_Debut(),voyage.getDate_Fin()).contains(vehicule) && voyage.getTypeVehicule().equals(vehicule.getTypeVehicule())){
            voyage.setVehicule(vehicule);
            return voyage;
        }
        else
        {throw new VehiculeNonDisponibleException("Vehicule n'est pas disponible ou ne convient pas a ce voyage.");}

    }

    @Override
    public Voyage getVoyage(Long id) throws VoyageNotFoundException {
      Voyage voyage= voyageRepository.findById(id).orElseThrow(()->new VoyageNotFoundException("voyage not found"));
        return voyage;
    }


}
