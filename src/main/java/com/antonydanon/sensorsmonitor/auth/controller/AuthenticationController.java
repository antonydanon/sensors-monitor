package com.antonydanon.sensorsmonitor.auth.controller;

import com.antonydanon.sensorsmonitor.auth.model.AuthRequestDto;
import com.antonydanon.sensorsmonitor.auth.model.AuthResponseDto;
import com.antonydanon.sensorsmonitor.auth.service.AuthService;
import com.antonydanon.sensorsmonitor.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto authRequestDto) {
        return ResponseEntity.ok(authService.login(authRequestDto));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@AuthenticationPrincipal User user) {
        authService.logout(user);
        return ResponseEntity.ok("Successful logout.");
    }
}
