package com.activityproject.activitytracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Time;
import java.time.*;
import java.util.UUID;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Activity {

     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
      UUID id;

      LocalDate doneDay;

      ZonedDateTime doneTime;

      float distance;
      Duration duration;
      float speed;
      float calories;

     @CreationTimestamp
      ZonedDateTime createdAt;


}
