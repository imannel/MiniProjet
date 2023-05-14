package com.example.gestionparcautomobil.entities;

import com.example.gestionparcautomobil.enums.TypePermis;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permis {
    @Id
    private String NPermis ;
    private LocalDateTime expirationDate ;
    @Enumerated(EnumType.STRING)
    private TypePermis type;
    @ManyToOne
    private Conducteur conducteur;
}

