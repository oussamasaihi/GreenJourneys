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
public class Activity implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long idActivity;
    private String Name;
    private String Region;
    private String Description;
    private String Address;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "activity")
    private List<Review> reviews;
}