package com.example.gestionparcautomobil.services;

import com.example.gestionparcautomobil.dtos.ConducteurDTO;
import com.example.gestionparcautomobil.entities.Conducteur;
import com.example.gestionparcautomobil.entities.Permis;
import com.example.gestionparcautomobil.entities.Vehicule;
import com.example.gestionparcautomobil.enums.TypePermis;
import com.example.gestionparcautomobil.exceptions.ConducteurNotFoundException;
import com.example.gestionparcautomobil.mappers.ConducteurMapperImpl;
import com.example.gestionparcautomobil.reposirories.ConducteurRepository;
import com.example.gestionparcautomobil.reposirories.PermisRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConducteurServiceImpl implements ConducteurService {
    @Autowired
    private ConducteurRepository conducteurRepository;
    @Autowired
    private PermisRepository permisRepository;
    @Autowired
    private ConducteurMapperImpl conducteurMapper;
    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    @Override
    public ConducteurDTO saveConducteur(ConducteurDTO conducteurDTO) {
        log.info("saving new Conducteur");
        Conducteur conducteur =conducteurMapper.fromConducteurDTO( conducteurDTO);
        Conducteur savedConducteur = conducteurRepository.save(conducteur);
        return conducteurMapper.fromConducteur(savedConducteur);
    }
    @Override
    public void deleteConducteur(Long conducteurId) {
        conducteurRepository.deleteById(conducteurId);
    }



    @Override
    public Permis savePermis(long conducteurId, TypePermis type, LocalDateTime dateExp) throws ConducteurNotFoundException {
        Permis permis = new Permis();
        Conducteur conducteur=conducteurRepository.findById(conducteurId).orElse(null);
        if(conducteur==null)
            throw new ConducteurNotFoundException("Conducteur not found");
        else permis.setConducteur(conducteur);

        permis.setNPermis(UUID.randomUUID().toString());
        permis.setType(type);
        permis.setExpirationDate(dateExp);

        return null;
    }


    @Override
    public List<Permis> listPermis(long conducteurId) {

        return permisRepository.findAll();
    }

    @Override
    public List<ConducteurDTO> listConducteur() {

        List<Conducteur>conducteurs = conducteurRepository.findAll();
       List<ConducteurDTO> conducteurDTOS=conducteurs.stream().map(cond->conducteurMapper.fromConducteur(cond)).collect(Collectors.toList());
       return conducteurDTOS;

    }

    @Override
    public ConducteurDTO getConducteur(Long id) throws ConducteurNotFoundException {
        Conducteur conducteur = conducteurRepository.findById(id).orElseThrow(()->new ConducteurNotFoundException("conducteur not found"));

        return conducteurMapper.fromConducteur(conducteur);
    }

    @Override
    public List<Conducteur> listConducteurDisponnible(LocalDateTime dateDebut, LocalDateTime dateFin) {
       return conducteurRepository.listConducteurDisponnible(dateDebut,dateFin);

    }
    @Override
    public boolean peutConduireTypeVehicule(Conducteur conducteur, String typeVehicule) {

        for (Permis permis : conducteur.getPermis()) {
            if (permis.getType().name().equals(typeVehicule) && permis.getExpirationDate().isAfter(LocalDateTime.now())) {
                return true;
            }
        }
        return true;
    }
}
