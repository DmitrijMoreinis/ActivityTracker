package com.activityproject.activitytracker.security;

import com.activityproject.activitytracker.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        com.activityproject.activitytracker.model.User user = userRepository.findByName(name)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return new User(
                user.getName(),
                user.getPassword(),
                Collections.emptyList());

    }
}
