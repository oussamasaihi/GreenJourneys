package com.greenjourneys.entities;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@ToString
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long idEvent;
    private LocalDate dateDebutEvent;
    private LocalDate dateFinEvent;
    private String regionEvent;
    private String nomEvent;
    private String descriptionEvent;

    @ManyToOne
    private User user;

}
