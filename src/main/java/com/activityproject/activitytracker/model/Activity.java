package com.activityproject.activitytracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;
import java.sql.Time;
import java.time.*;
import java.util.UUID;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)

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

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;

     @CreationTimestamp
      ZonedDateTime createdAt;


}
