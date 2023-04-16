package com.greenjourneys.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@ToString
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Accomodation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long idAccomodation;
    private String name ;
    private long Telnumber;
    private String Address ;
    private String email ;
    @Enumerated(EnumType.STRING)
    private TypeAccomodation typeAcc ;
    private int Stars ;
    @OneToMany(mappedBy = "accomodation")
    private static List<Review> reviews;

}
