package com.greenjourneys.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_User")
    long id ;
    String nom ;
    String prenom ;
    LocalDate Date_naissance ;
    String email ;
    String MotDePasse ;
    long numtel ;
    Role role ;
    @OneToMany(mappedBy = "user")
    private List<Activity> activities;
    @OneToMany(mappedBy = "user")
    private List<Event> events;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

}
