package com.greenjourneys.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;

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
    LocalDate dateDebut;
    LocalDate dateFin;
    long prixtotale;
    @ManyToMany
    List<Chambre> chambres;
    @ManyToOne
    Accomodation accommodation1;
    @ManyToOne
    User user;

}
