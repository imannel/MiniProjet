package com.example.gestionparcautomobil.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class CarteGrise {
  @Id
    private Long id ;
    private Date date_LCG;// Date de livraison de la carte grise
    private String societe ;
    @OneToOne
    private Vehicule vehicule;

}
