package com.example.gestionparcautomobil.mappers;

import com.example.gestionparcautomobil.dtos.ConducteurDTO;
import com.example.gestionparcautomobil.entities.Conducteur;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ConducteurMapperImpl {
    public ConducteurDTO fromConducteur(Conducteur conducteur){
        ConducteurDTO conducteurDTO=new ConducteurDTO();
        BeanUtils.copyProperties(conducteur,conducteurDTO);
        return  conducteurDTO;
    }
    public Conducteur fromConducteurDTO(ConducteurDTO conducteurDTO){
        Conducteur conducteur=new Conducteur();
        BeanUtils.copyProperties(conducteurDTO,conducteur);
        return  conducteur;
    }

}
