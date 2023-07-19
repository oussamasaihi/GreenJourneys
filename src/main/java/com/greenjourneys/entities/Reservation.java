package com.greenjourneys.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idR;
    LocalDate ReservationDate;
    String Mobile;
    LocalDate dateDebut;
    LocalDate dateFin;
    int TotalDays;
    long prixtotale;
    @ManyToMany(cascade =CascadeType.ALL)
    List<Chambre> chambres;
    @ManyToOne(cascade = CascadeType.ALL)
    Accomodation accommodation1;
    @ManyToOne
    User user;

}
