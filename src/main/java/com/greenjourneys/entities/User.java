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
@NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id_User ;
    private String nom ;
    private String prenom ;
    private LocalDate Date_naissance ;
    private String email ;
    private String MotDePasse ;
    private long numtel ;
    private Role role ;
    @JsonIgnore
    @OneToOne
    private Activity activity ;
    @JsonIgnore
    @OneToOne
    private Event event ;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
    @JsonIgnore
    @OneToMany
    private List<Reclamation> reclamations;

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
