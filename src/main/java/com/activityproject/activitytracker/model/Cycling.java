package com.activityproject.activitytracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Cycling extends Activity{


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "average_cadency")
    private float averageCadency;
    @Column(name = "average_power")
    private float averagePower;

    @ManyToOne
    @JoinColumn(name="name",nullable = false)
    private User user;

}
