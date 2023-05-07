package com.greenjourneys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long idChat;
    private String etat;
    private String privateMessage;
    private Date dateMessage;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "group_id"
    )
    private Group group;
    @JsonIgnore
    @OneToOne
    private User user;

}