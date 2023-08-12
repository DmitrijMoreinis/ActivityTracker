package com.activityproject.activitytracker.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.cglib.core.Local;

import java.sql.Date;
import java.sql.Time;
import java.time.*;

@MappedSuperclass
@NoArgsConstructor
@Data
public abstract class Activity {

     private LocalDate doneDay;

     private ZonedDateTime doneTime;

     private float distance;
     private Duration duration;
     private float speed;
     private float calories;

     @CreationTimestamp
     private ZonedDateTime createdAt;

}
