package com.example.gestionparcautomobil.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Conducteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    private String matricule;

    private LocalDateTime dateNaissance;

    private String cin;
    @OneToMany(mappedBy = "conducteur")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Permis> permis;
    @OneToMany(mappedBy = "conducteur")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Voyage> voyage;


}
