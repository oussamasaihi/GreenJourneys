package com.greenjourneys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
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
    private String Image ;
    private String AcDate ;
    private String AcTime;
    private String activityType;
    @JsonIgnore
    @OneToMany(mappedBy = "activity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Review> reviewsActivity ;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    @JsonIgnore
    public List<Review> getReviewsActivity() {
        return reviewsActivity;
    }



}