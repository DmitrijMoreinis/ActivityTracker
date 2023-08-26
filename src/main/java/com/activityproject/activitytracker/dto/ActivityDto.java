package com.activityproject.activitytracker.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
public abstract class ActivityDto {

   private UUID id;

   private LocalDate doneDay;

   private ZonedDateTime doneTime;


   @NotNull
   private float distance;

   private Duration duration;

   private float speed;

   private float calories;

   private ZonedDateTime createdAt;
}
