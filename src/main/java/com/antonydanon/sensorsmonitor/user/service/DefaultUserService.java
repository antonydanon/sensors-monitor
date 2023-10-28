package com.antonydanon.sensorsmonitor.user.service;

import com.antonydanon.sensorsmonitor.user.exception.UserNotFoundException;
import com.antonydanon.sensorsmonitor.user.model.User;
import com.antonydanon.sensorsmonitor.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) {
        return userRepository
                .findByLogin(username)
                .orElseThrow(() -> new UserNotFoundException("User hasn't been found."));
    }
}
