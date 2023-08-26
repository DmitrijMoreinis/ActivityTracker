package com.activityproject.activitytracker.extrastuff;


import com.activityproject.activitytracker.dto.CyclingDto;
import com.activityproject.activitytracker.model.Cycling;
import com.activityproject.activitytracker.model.Role;
import com.activityproject.activitytracker.model.User;
import com.activityproject.activitytracker.repository.CyclingRepository;
import com.activityproject.activitytracker.service.CyclingService;
import com.activityproject.activitytracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;

    @Component
    @RequiredArgsConstructor
    public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {


        private final UserService userService;
        private final CyclingService cyclingService;

        public void onApplicationEvent(ApplicationReadyEvent event) {
            userService.saveRole(new Role("ROLE_USER"));

            userService.saveRole(new Role("ROLE_ADMIN"));

            User u= new User("primo", "user", "1234", new ArrayList<>());

            userService.saveUser(u);
            userService.saveUser(new User("secondo", "user2", "1234", new ArrayList<>()));
            userService.saveUser(new User("admin", "admin", "1234", new ArrayList<>()));

            userService.addRoleToUser("user", "ROLE_USER");
            userService.addRoleToUser("user2", "ROLE_USER");
            userService.addRoleToUser("admin", "ROLE_ADMIN");



            cyclingService.createActivity(new CyclingDto());



        }



    }
