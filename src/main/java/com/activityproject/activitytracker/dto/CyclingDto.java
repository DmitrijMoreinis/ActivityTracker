package com.activityproject.activitytracker.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CyclingDto extends ActivityDto{

    private float averageCadency;
    private float averagePower;

}