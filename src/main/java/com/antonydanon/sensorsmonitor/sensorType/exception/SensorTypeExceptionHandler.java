package com.antonydanon.sensorsmonitor.sensorType.exception;

import com.antonydanon.sensorsmonitor.general.exception.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class SensorTypeExceptionHandler {

    @ExceptionHandler(SensorTypeNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleSensorTypeNotFoundException(SensorTypeNotFoundException e) {
        return ResponseEntity.status(NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
    }
}
