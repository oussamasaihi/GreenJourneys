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
    String nomCH;
    int capacite ;
    long prixComplet;
    long prixDemiPortion;
    long reductionEnfant;
    long superfice;
    @Enumerated(EnumType.STRING)
    TypeCh typech;
    @ManyToOne
    Accomodation accommodation;
    Long Fileid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chambre chambre = (Chambre) o;
        return idCH == chambre.idCH && capacite == chambre.capacite
                && prixComplet == chambre.prixComplet && prixDemiPortion == chambre.prixDemiPortion
                && reductionEnfant == chambre.reductionEnfant && superfice == chambre.superfice
                && Objects.equals(nomCH, chambre.nomCH) && typech == chambre.typech
                && Objects.equals(accommodation, chambre.accommodation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCH, nomCH, capacite, prixComplet, prixDemiPortion, reductionEnfant, superfice, typech, accommodation);
    }
}
