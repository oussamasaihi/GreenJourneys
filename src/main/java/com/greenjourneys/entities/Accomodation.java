package com.greenjourneys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@ToString
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Accomodation implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idAccomodation;
    String name ;
    String ville;
    String addresse ;
    String email;
    String amenities;
    @Enumerated(EnumType.STRING)
    TypeAccomodation typeAcc ;
    int stars ;
    String description;
    @JsonIgnore
    @OneToMany(mappedBy = "accommodation")
    Set<Chambre> chambres;
    @JsonIgnore
    @OneToMany(mappedBy = "accommodation1")
    Set<Reservation> reservations;
    Long Fileid;

}
