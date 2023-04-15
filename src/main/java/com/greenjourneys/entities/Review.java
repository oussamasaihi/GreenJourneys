package com.greenjourneys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Builder // bech nasna3 ay type de constructeur
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Review implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "idReview")
    private long id;
    @Column(name = "rate from 1 to 5")
    private int rate;
    @Column(name = "Comment to Review")
    private String comment;
    @JsonIgnore
    @ManyToOne
    private Activity activity;
    @ManyToOne
    private Event event;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}