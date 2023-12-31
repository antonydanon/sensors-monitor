package com.antonydanon.sensorsmonitor.auth.service;

import com.antonydanon.sensorsmonitor.auth.model.AuthRequestDto;
import com.antonydanon.sensorsmonitor.auth.model.AuthResponseDto;
import com.antonydanon.sensorsmonitor.security.jwt.JwtService;
import com.antonydanon.sensorsmonitor.user.model.User;
import com.antonydanon.sensorsmonitor.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultAuthService implements AuthService {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Transactional
    public AuthResponseDto login(AuthRequestDto authRequestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDto.getLogin(), authRequestDto.getPassword())
        );
        User user = (User) userService.loadUserByUsername(authRequestDto.getLogin());
        String token = jwtService.generateToken(user);
        userService.saveToken(user, token);
        return new AuthResponseDto(token);
    }

    @Override
    public void logout(User user) {
        userService.saveToken(user, null);
    }
}