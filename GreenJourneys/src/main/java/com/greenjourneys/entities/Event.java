package com.greenjourneys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Event implements Serializable{
    @Id
    private long IdEvent;
    @Temporal(TemporalType.DATE)
    @Column(
            name = "dateDebut"
    )
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    @Column(
            name = "dateFin"
    )
    private Date dateFin;
    @Column(
            name = "archive",
            columnDefinition = "boolean default false"
    )
    private Boolean archive = false;
    private String region;
    private String nom;
    private String description;
    @JsonIgnore
    @OneToMany
    List<Review> reviewsEvent ;




}