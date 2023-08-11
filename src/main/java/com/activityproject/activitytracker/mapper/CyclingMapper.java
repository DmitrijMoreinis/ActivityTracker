package com.activityproject.activitytracker.mapper;

import com.activityproject.activitytracker.dto.CyclingDto;
import com.activityproject.activitytracker.model.Cycling;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;


    @Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
    public interface CyclingMapper {

        public CyclingDto toDto(Cycling entity);

        public Cycling toEntity(CyclingDto cyclingDto);

    }

