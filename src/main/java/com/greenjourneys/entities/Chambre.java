package com.greenjourneys.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long idCH ;
    String NomCH;
    int Capacite ;
    long PrixComplet;
    long PrixDemiPortion;
    long ReductionEnfant;
    long Superfice;
    @Enumerated(EnumType.STRING)
    TypeCh typech;
    @ManyToOne
    Accomodation accommodation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chambre chambre = (Chambre) o;
        return idCH == chambre.idCH && Capacite == chambre.Capacite
                && PrixComplet == chambre.PrixComplet && PrixDemiPortion == chambre.PrixDemiPortion
                && ReductionEnfant == chambre.ReductionEnfant && Superfice == chambre.Superfice
                && Objects.equals(NomCH, chambre.NomCH) && typech == chambre.typech
                && Objects.equals(accommodation, chambre.accommodation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCH, NomCH, Capacite, PrixComplet, PrixDemiPortion, ReductionEnfant, Superfice, typech, accommodation);
    }
}
