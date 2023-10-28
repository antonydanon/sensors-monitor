package com.antonydanon.sensorsmonitor.sensorType.controller;

import com.antonydanon.sensorsmonitor.sensorType.model.SensorType;
import com.antonydanon.sensorsmonitor.sensorType.service.SensorTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/sensor-type")
public class SensorTypeController {

    private final SensorTypeService sensorTypeService;

    @GetMapping
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<List<SensorType>> getAll() {
        return ResponseEntity.ok(sensorTypeService.getAll());
    }
}
