package com.activityproject.activitytracker.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    private String name;
    private String password;
    @Temporal(value = TemporalType.DATE)
    @Column(name="date_of_birth")
    private Date birthDate;
    private float weight;
    @Column(name = "overall_distance_cycling")
    private float overallDistanceCycling;
    @Column(name = "overall_distance_running")
    private float overallDistanceRunning;
    private Date createdAt;
    private Date updatedAt;


    @OneToMany(mappedBy = "user")
    private List<Cycling> cyclingList;
    @OneToMany(mappedBy = "user")
    private List<Cycling> runningList;

}
