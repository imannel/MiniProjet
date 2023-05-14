package com.example.gestionparcautomobil.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConducteurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDateTime dateNaissance;
    private String cin;
}
