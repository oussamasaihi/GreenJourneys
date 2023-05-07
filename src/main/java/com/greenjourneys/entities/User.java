package com.greenjourneys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
public class User {
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setReclamations(List<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String firstname;

    private String lastname;


    private String username;

    private String password;


    private String token;


    private String email;

    private boolean enabled;
    private String resetPasswordToken ;



    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idRole")
    )
    private Set<Role> roles = new HashSet<>();





    @JsonIgnore
    @OneToOne
    private Activity activity ;
    @JsonIgnore
    @OneToOne
    private Event event ;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
    @JsonIgnore
    @OneToMany
    private List<Reclamation> reclamations;
    public Set<Role> getRoles() {
        return this.roles;
    }


    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }


    public Activity getActivity() {
        return activity;
    }

    public Event getEvent() {
        return event;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Reclamation> getReclamations() {
        return reclamations;
    }
    @ManyToMany(
            mappedBy = "users"
    )
    private List<Interest> interest;
    @JsonIgnore
    @ManyToMany(
            mappedBy = "users"
    )
    private List<Group> groups = new ArrayList<>();
}
