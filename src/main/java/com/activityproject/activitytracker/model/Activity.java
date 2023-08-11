package com.activityproject.activitytracker.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@MappedSuperclass
public abstract class Activity {

     @Temporal(value= TemporalType.DATE)
     Date doneDay;

     @Temporal(value= TemporalType.TIME)
     Time doneTime;

     float distance;
     Duration duration;
     float speed;
     float calories;

     @CreationTimestamp
     ZonedDateTime createdAt;

}
