package com.greenjourneys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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



    @ManyToMany(
            mappedBy = "users"
    )
    private List<Interest> interest;
    @JsonIgnore
    @ManyToMany(
            mappedBy = "users"
    )
    private List<Group> groups = new ArrayList();

}
