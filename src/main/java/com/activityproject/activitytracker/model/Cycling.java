package com.activityproject.activitytracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Entity
@Data

public class Cycling extends Activity{


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "average_cadency")
    private float averageCadency;
    @NotNull
    @Column(name = "average_power")
    private float averagePower;

    @ManyToOne
    @JoinColumn(name="name",nullable = false)
    private User user;


}
