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
    public List<Review> getReviewsActivity() {
        return reviewsActivity;
    }
    @JsonIgnore
    @OneToMany
    List<Review> reviewsActivity ;
    @JsonIgnore
    @OneToOne
    User user ;
}