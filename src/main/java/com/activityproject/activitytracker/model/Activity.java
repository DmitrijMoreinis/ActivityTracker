package com.activityproject.activitytracker.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.cglib.core.Local;

import java.sql.Date;
import java.sql.Time;
import java.time.*;
import java.util.UUID;

@MappedSuperclass
@NoArgsConstructor
@Data
public abstract class Activity {

     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;
     private LocalDate doneDay;

     private ZonedDateTime doneTime;

     private float distance;
     private Duration duration;
     private float speed;
     private float calories;

     @CreationTimestamp
     private ZonedDateTime createdAt;

}
