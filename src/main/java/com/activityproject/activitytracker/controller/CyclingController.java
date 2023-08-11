package com.activityproject.activitytracker.controller;

import com.activityproject.activitytracker.dto.CyclingDto;
import com.activityproject.activitytracker.service.CyclingService;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CyclingController {

    private final CyclingService cyclingService;

    @PostMapping("/cycling/createActivity")
    public ResponseEntity<CyclingDto> createActivity(@RequestBody @Valid CyclingDto cyclingDto) {
        CyclingDto reDto = cyclingService.createActivity(cyclingDto);
        ResponseEntity re = new ResponseEntity<>(reDto, HttpStatus.CREATED);
        return re;
    }

    @GetMapping("/cycling/all")
    public List<CyclingDto> findAll() {
        return cyclingService.findAll();
    }

    @GetMapping("/{id}")
    public CyclingDto findById(@PathVariable Long id) {
        return cyclingService.findById(id);
    }

    @PutMapping("/{id}")
    public CyclingDto update(@PathVariable Long id, @RequestBody @Valid CyclingDto medicationDto) {
        return cyclingService.updateMedication(id, medicationDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        cyclingService.deleteMedication(id);
    }





}
