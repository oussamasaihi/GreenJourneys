package com.greenjourneys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "groupe"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "group_user",
            joinColumns = {@JoinColumn(
                    name = "group_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "user_id"
            )}
    )
    private List<User> users = new ArrayList();
    @JsonIgnore
    @OneToMany(
            mappedBy = "group"
    )
    private List<Chat> chats = new ArrayList();
}