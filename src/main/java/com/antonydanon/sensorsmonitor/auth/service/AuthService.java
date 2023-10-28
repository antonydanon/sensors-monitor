package com.antonydanon.sensorsmonitor.auth.service;

import com.antonydanon.sensorsmonitor.auth.model.AuthRequestDto;
import com.antonydanon.sensorsmonitor.auth.model.AuthResponseDto;

public interface AuthService {
    AuthResponseDto login(AuthRequestDto authRequestDto);
}
