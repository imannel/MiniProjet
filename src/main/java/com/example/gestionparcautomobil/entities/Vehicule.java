package com.example.gestionparcautomobil.entities;

import com.example.gestionparcautomobil.enums.TypePermis;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule {
    @Id
    private String Matricule;
    private Date miseCirculation ;
    private String modele;
    private String typeVehicule;
    private boolean etat_Operationnel;
    private TypePermis permis ;
    @OneToMany(mappedBy = "vehicule")
    private List<Voyage> voyages;
    @OneToMany(mappedBy = "vehicule" )
    private List<Depence> depences;
    @OneToOne
    private CarteGrise carteGrise;

}
