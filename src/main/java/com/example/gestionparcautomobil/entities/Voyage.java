package com.example.gestionparcautomobil.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Voyage {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @ManyToOne
    private Conducteur conducteur;
    @ManyToOne
    private Vehicule vehicule;
    private LocalDateTime Date_Debut;
    private LocalDateTime Date_Fin;
    private String VilDep;
    private String VilAr;

    private String typeVehicule;
}
