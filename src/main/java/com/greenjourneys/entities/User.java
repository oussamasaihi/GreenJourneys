package com.greenjourneys.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

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
    @OneToMany(mappedBy = "user")
    Set<Reservation> reservations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return  Objects.equals(getId_user(), user.getId_user());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
