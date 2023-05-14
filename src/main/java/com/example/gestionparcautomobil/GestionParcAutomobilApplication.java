package com.example.gestionparcautomobil;

import com.example.gestionparcautomobil.dtos.ConducteurDTO;
import com.example.gestionparcautomobil.entities.Conducteur;
import com.example.gestionparcautomobil.entities.Permis;
import com.example.gestionparcautomobil.entities.Voyage;
import com.example.gestionparcautomobil.enums.TypePermis;
import com.example.gestionparcautomobil.mappers.ConducteurMapperImpl;
import com.example.gestionparcautomobil.reposirories.ConducteurRepository;
import com.example.gestionparcautomobil.reposirories.PermisRepository;
import com.example.gestionparcautomobil.reposirories.VehiculeRepository;
import com.example.gestionparcautomobil.services.ConducteurService;
import com.example.gestionparcautomobil.services.UserService;
import com.example.gestionparcautomobil.services.VoyageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class GestionParcAutomobilApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionParcAutomobilApplication.class, args);
    }
    @Bean
    CommandLineRunner start(VoyageService voyageService, ConducteurService conducteurService, ConducteurMapperImpl conducteurMapper, UserService userService){
        return args ->{
           LocalDateTime localDateTime1 = LocalDateTime.parse("2022-01-25T00:00:00.00001");
          LocalDateTime localDateTime2 = LocalDateTime.parse("2022-01-27T00:00:00.00001");
         //List<Conducteur> conducteurs=   conducteurService.listConducteurDisponnible(localDateTime1,localDateTime2);
         //   for (Conducteur conducteur : conducteurs) {
          //      System.out.println(conducteur.getNom());
          //  }

           // Voyage v =voyageService.PlanifierVoyage(localDateTime1,localDateTime2,"CatégorieA");

             voyageService.AffectationConducteur(12, 1);
             //userService.getUsers(user);
            //userService.addRoleToUser("Manal","ADMIN");
         //   ConducteurDTO cond= conducteurService.getConducteur(1L);
         //  Voyage voyage = voyageService.getVoyage(12L);
           //  String typeVehicule =voyage.getTypeVehicule();
        ////     System.out.println(typeVehicule);

        //    for (Permis permis : conducteurMapper.fromConducteurDTO(cond).getPermis()) {

           //       System.out.println(permis.getType().name());

          //  }
        };

    }


}
