package com.activityproject.activitytracker.controller;

import com.activityproject.activitytracker.service.RunningService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor

public class RunningController {

    private final RunningService runningService;

}
