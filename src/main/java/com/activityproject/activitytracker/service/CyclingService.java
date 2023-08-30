package com.activityproject.activitytracker.service;


import com.activityproject.activitytracker.dto.CyclingDto;
import com.activityproject.activitytracker.mapper.CyclingMapper;
import com.activityproject.activitytracker.model.Cycling;
import com.activityproject.activitytracker.repository.CyclingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j

public class CyclingService {


    private final CyclingMapper mapper;

    private final CyclingRepository cyclingRepository;


    public CyclingDto createActivity(CyclingDto cyclingDto) {
        Cycling cycling= mapper.toEntity(cyclingDto);
        cyclingRepository.save(cycling);
        log.info("cyclingactivity saved");
        return mapper.toDto(cycling);
    }

    public List<CyclingDto> findAll() {
        return cyclingRepository.findAll().stream().map(mapper::toDto).toList();
    }

    public CyclingDto deleteCycling(UUID id) {
        Optional<Cycling> re = cyclingRepository.findById(id);
        if(re.isPresent()){
            log.info("cylingactivity deleting");

            cyclingRepository.deleteById(id);
            log.info("cylingactivity deleted");
        return mapper.toDto(re.get()) ;}
        else throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "activity not found-database_error");

    }

    public CyclingDto updateCycling(UUID id, CyclingDto cyclingDto) {
        if(!cyclingRepository.existsById(id)) {
            throw new EntityNotFoundException("No Cyclingactivity with id " + id);
        }
        Cycling entity = mapper.toEntity(cyclingDto);
        entity.setId(id);
        log.info("cylingactivity updating");

        cyclingRepository.save(entity);

        return mapper.toDto(entity);
    }

    public CyclingDto findById(UUID id) {
     return mapper.toDto(cyclingRepository.findById(id)
             .orElseThrow(()->new ResponseStatusException(
                     HttpStatus.NOT_FOUND, "activity not found")));

    }
}
