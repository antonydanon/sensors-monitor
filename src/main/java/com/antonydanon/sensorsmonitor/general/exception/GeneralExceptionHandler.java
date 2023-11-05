package com.antonydanon.sensorsmonitor.general.exception;

import com.antonydanon.sensorsmonitor.general.model.ExceptionResponse;
import com.antonydanon.sensorsmonitor.general.model.ValidationErrorResponse;
import com.antonydanon.sensorsmonitor.general.model.Violation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        final List<Violation> violations = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new Violation(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.status(BAD_REQUEST).body(new ValidationErrorResponse(violations));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(BAD_REQUEST).body(new ExceptionResponse(e.getMessage()));
    }
}
