package com.activityproject.activitytracker.repository;

import com.activityproject.activitytracker.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
