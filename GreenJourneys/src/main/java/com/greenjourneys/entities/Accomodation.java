package com.greenjourneys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@ToString
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Accomodation implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long idAccomodation;
    private String name ;
    private long Telnumber;
    private String Address ;
    private String Email ;
    @Enumerated(EnumType.STRING)
    private TypeAccomodation typeAcc ;
    private int Stars ;
    @JsonIgnore
    @OneToOne
    User user ;
    @JsonIgnore
    @OneToMany
    List<Review> reviewsAcc ;



}
