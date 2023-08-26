package com.activityproject.activitytracker.controller;

import com.activityproject.activitytracker.dto.CyclingDto;
import com.activityproject.activitytracker.service.CyclingService;
import jakarta.validation.Valid;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/api/v1/cycling")
public class CyclingController {

    private final CyclingService cyclingService;

    @GetMapping("/test")
    public String testResponse(){return "chesterfield";}

    @PostMapping
    public ResponseEntity<CyclingDto> createActivity(@RequestBody @Valid CyclingDto cyclingDto) {
        CyclingDto reDto = cyclingService.createActivity(cyclingDto);
        ResponseEntity re = new ResponseEntity<>(reDto, HttpStatus.CREATED);
        return re;
    }

    @GetMapping
    public List<CyclingDto> findAll() {
        return cyclingService.findAll();

    }

    @GetMapping("/{id}")
    public CyclingDto findById(@PathVariable UUID id) {
        return cyclingService.findById(id);
    }

    @PutMapping("/{id}")
    public CyclingDto updateCycling(@PathVariable UUID id, @RequestBody @Valid CyclingDto cyclingDto) {
        return cyclingService.updateCycling(id, cyclingDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        cyclingService.deleteCycling(id);
    }

}
