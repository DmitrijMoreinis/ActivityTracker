package com.activityproject.activitytracker.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CyclingDto {

    Date doneDay;

    Time doneTime;

    float distance;
    Duration duration;
    float speed;
    float calories;
    ZonedDateTime createdAt;
    private UUID id;
    private float averageCadency;
    private float averagePower;
    private String name;
}
