package com.activityproject.activitytracker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("api/v1/greet")
    @Slf4j
    public class GreetController {

        @GetMapping
        public String greet() {
            var authentication = SecurityContextHolder.getContext().getAuthentication();
            log.info("User {} has role {}", authentication.getName(), authentication.getAuthorities());
            return "hello " + authentication.getName();
        }
}
