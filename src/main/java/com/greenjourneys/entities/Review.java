package com.greenjourneys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private long id;

    private int rate;

    private String comment ;
    @JsonIgnore
    @ManyToOne
    private Activity activity;
    @JsonIgnore
    @ManyToOne
    private Accomodation accomodation;
    @JsonIgnore
    @ManyToOne
    private Event event;
    @JsonIgnore
    @ManyToOne
    private User user;


}