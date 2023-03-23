package com.greenjourneys.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)

    private Integer idTransport;
    @Enumerated(EnumType.STRING)
    private Type_Moyen type_moyen;
    private Long distance;

    @ManyToOne
    private User user;

}
