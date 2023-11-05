package com.antonydanon.sensorsmonitor.user.exception;

import com.antonydanon.sensorsmonitor.general.model.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleUserNotFound(UserNotFoundException e) {
        return ResponseEntity.status(NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
    }
}
