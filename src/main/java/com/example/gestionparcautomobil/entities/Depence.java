package com.example.gestionparcautomobil.entities;

import com.example.gestionparcautomobil.enums.TypePermis;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Depence {
    @Id
    private Long id_depense ;
    @ManyToOne
    private Vehicule vehicule ;
    private String type_depence;

    private Date date_depence;
    private double montant ;}


