package com.greenjourneys.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class User {
    @Id
    long id_user ;
    String nom ;
    String prenom ;
    LocalDate Date_naissance ;
    String email ;
    String MotDePasse ;
    long numtel ;
    Role role ;

}
