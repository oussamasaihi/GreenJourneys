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
    @JoinColumn(name = "review_id")
    private Review review;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "Event")
    private List<Review> reviews;
}