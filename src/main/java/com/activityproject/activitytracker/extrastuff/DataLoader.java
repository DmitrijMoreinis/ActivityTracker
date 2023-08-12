package com.activityproject.activitytracker.extrastuff;

import com.activityproject.activitytracker.mapper.CyclingMapper;
import com.activityproject.activitytracker.model.Cycling;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {


    private final CyclingMapper cyclingMapper;



    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Cycling cycling= new Cycling();

        cycling.setId(UUID.randomUUID());
        cycling.setAveragePower(10);

        var dto = cyclingMapper.toDto(cycling);
        System.out.println(dto);


    }
}