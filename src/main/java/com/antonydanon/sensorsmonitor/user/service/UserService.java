package com.antonydanon.sensorsmonitor.user.service;

import com.antonydanon.sensorsmonitor.user.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User saveToken(User user, String token);
}
