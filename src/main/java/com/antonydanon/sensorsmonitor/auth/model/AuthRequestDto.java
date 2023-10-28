package com.antonydanon.sensorsmonitor.auth.model;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String login;
    private String password;
}