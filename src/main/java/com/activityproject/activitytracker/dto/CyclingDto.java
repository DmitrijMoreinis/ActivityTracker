package com.activityproject.activitytracker.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
public class CyclingDto extends ActivityDto{

    private float averageCadency;
    private float averagePower;

}
