package com.greenjourneys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@Builder // bech nasna3 ay type de constructeur
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Event implements Serializable {
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
    private String Region;
    private String Nom;
    private String Description;
    @JsonIgnore
    @ManyToOne
    private User user;
}