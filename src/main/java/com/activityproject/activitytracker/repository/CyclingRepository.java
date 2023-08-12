package com.activityproject.activitytracker.repository;

import com.activityproject.activitytracker.model.Cycling;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface CyclingRepository extends JpaRepository<Cycling, UUID> {
}
