package com.example.gestionparcautomobil.web;

import com.example.gestionparcautomobil.dtos.ConducteurDTO;
import com.example.gestionparcautomobil.entities.Conducteur;
import com.example.gestionparcautomobil.exceptions.ConducteurNonDisponibleException;
import com.example.gestionparcautomobil.exceptions.ConducteurNotFoundException;
import com.example.gestionparcautomobil.exceptions.VehiculeNotFoundException;
import com.example.gestionparcautomobil.exceptions.VoyageNotFoundException;
import com.example.gestionparcautomobil.services.ConducteurService;
import com.example.gestionparcautomobil.services.VoyageService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@Slf4j
public class ConducteurRestController {
    private ConducteurService conducteurService;
    private VoyageService voyageService;

    @GetMapping("/api/v1/conducteurs")
    public List<ConducteurDTO> Conducteurs() {
        return conducteurService.listConducteur();
    }

    @GetMapping("/api/v1/conducteurs/{id}")
    public ConducteurDTO getConducteur(@PathVariable(name = "id") Long conducteurId) throws ConducteurNotFoundException {
        return conducteurService.getConducteur(conducteurId);
    }

    @PostMapping("/api/v1/conducteurs")
    public ConducteurDTO saveConducteur(@RequestBody ConducteurDTO conducteurDTO) {
        return conducteurService.saveConducteur(conducteurDTO);
    }

    @DeleteMapping("/api/v1/conducteurs/{id}")
    public void deleteConducteur(@PathVariable(name = "id") Long conducteurId) {
        conducteurService.deleteConducteur(conducteurId);
    }
    @PostMapping("/api/v1/affectaionConducteurToVoyage")
    public void affectationConducteur(@RequestBody ConducteurVehiculeForm conducteurVehiculeForm) throws ConducteurNotFoundException, VoyageNotFoundException, ConducteurNonDisponibleException {
       voyageService.AffectationConducteur(conducteurVehiculeForm.getVoyageId(),conducteurVehiculeForm.getConducteurId());
    }

}
@Data
 class ConducteurVehiculeForm{
    private  Long voyageId;
    private  Long conducteurId;
 }