package com.activityproject.activitytracker.service;


import com.activityproject.activitytracker.dto.CyclingDto;
import com.activityproject.activitytracker.mapper.CyclingMapper;
import com.activityproject.activitytracker.model.Cycling;
import com.activityproject.activitytracker.repository.CyclingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CyclingService {

    private final CyclingMapper mapper;

    private final CyclingRepository cyclingRepository;


    public CyclingDto createActivity(CyclingDto cyclingDto) {
        Cycling cycling= mapper.toEntity(cyclingDto);
        cyclingRepository.save(cycling);
        return mapper.toDto(cycling);
    }

    public List<Cycling> findAll() {
        return cyclingRepository.findAll();
    }

    public void deleteMedication(Long id) {
    }

    public CyclingDto updateMedication(Long id, CyclingDto medicationDto) {
    }

    public CyclingDto findById(Long id) {
    }
}
