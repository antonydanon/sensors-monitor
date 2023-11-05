package com.antonydanon.sensorsmonitor.sensorUnit.exception;

import com.antonydanon.sensorsmonitor.general.model.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class SensorUnitExceptionHandler {

    @ExceptionHandler(SensorUnitNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleSensorUnitNotFoundException(SensorUnitNotFoundException e) {
        return ResponseEntity.status(NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
    }
}
