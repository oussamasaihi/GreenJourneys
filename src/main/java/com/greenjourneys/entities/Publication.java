package com.greenjourneys.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "publication")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "pub_date")
    private Date pubDate;

    @Column(name = "content")
    private String content;

    //Publication with Reaction
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "publication_id")
    private List<Reaction> reactions = new ArrayList<>();

    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new LinkedHashSet<>();
    public void addReaction(React react) {
        Reaction reaction = new Reaction();
        reaction.setReact(react);
        reactions.add(reaction);
    }
}