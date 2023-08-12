package com.activityproject.activitytracker.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZonedDateTime;


@Data
@NoArgsConstructor
public abstract class ActivityDto {
   private LocalDate doneDay;

   private ZonedDateTime doneTime;

   private String name;

   private float distance;

   private Duration duration;

   private float speed;

   private float calories;

   private ZonedDateTime createdAt;
}
