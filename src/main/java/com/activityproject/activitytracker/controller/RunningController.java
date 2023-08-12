package com.activityproject.activitytracker.controller;

import com.activityproject.activitytracker.dto.RunningDto;
import com.activityproject.activitytracker.service.RunningService;
import jakarta.validation.Valid;;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/running")

public class RunningController {

    private final RunningService runningService;


    @PostMapping
    public ResponseEntity<RunningDto> createActivity(@RequestBody @Valid RunningDto runningDto) {
        RunningDto reDto = runningService.createActivity(runningDto);
        ResponseEntity re = new ResponseEntity<>(reDto, HttpStatus.CREATED);
        return re;
    }

    @GetMapping
    public List<RunningDto> findAll() {
        return runningService.findAll();
    }

    @GetMapping("/{id}")
    public RunningDto findById(@PathVariable UUID id) {
        return runningService.findById(id);
    }

    @PutMapping("/{id}")
    public RunningDto updateRunning(@PathVariable UUID id, @RequestBody @Valid RunningDto runningDto) {
        return runningService.updateRunning(id, runningDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        runningService.deleteRunning(id);
    }

}
