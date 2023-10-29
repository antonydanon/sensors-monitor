package com.antonydanon.sensorsmonitor.auth.service;

import com.antonydanon.sensorsmonitor.auth.model.AuthRequestDto;
import com.antonydanon.sensorsmonitor.auth.model.AuthResponseDto;
import com.antonydanon.sensorsmonitor.user.model.User;

public interface AuthService {
    AuthResponseDto login(AuthRequestDto authRequestDto);
    void logout(User user);
}
