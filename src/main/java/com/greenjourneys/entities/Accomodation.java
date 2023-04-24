package com.greenjourneys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

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
    String Addresse ;
    @Enumerated(EnumType.STRING)
    TypeAccomodation typeAcc ;
    int Stars ;
    @JsonIgnore
    @OneToMany(mappedBy = "accommodation")
    Set<Chambre> chambres;
    @JsonIgnore
    @OneToMany(mappedBy = "accommodation1")
    Set<Reservation> reservations;


}
