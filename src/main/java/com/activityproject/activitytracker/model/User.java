package com.activityproject.activitytracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    private String username;
    private String password;
    @Temporal(value = TemporalType.DATE)
    @Column
    private Date birthDate;
    private float weight;
    @Column
    private float overallDistanceCycling;
    @Column
    private float overallDistanceRunning;
    private Date createdAt;
    private Date updatedAt;


    @OneToMany(mappedBy = "user")
    private List<Cycling> cyclingList;
    @OneToMany(mappedBy = "user")
    private List<Cycling> runningList;

    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public <E> User(String primoTizio, String user, String number, ArrayList<E> es) {
    }
}

