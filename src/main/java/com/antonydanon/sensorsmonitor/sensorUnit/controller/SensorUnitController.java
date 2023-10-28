package com.antonydanon.sensorsmonitor.sensorUnit.controller;

import com.antonydanon.sensorsmonitor.sensorUnit.model.SensorUnit;
import com.antonydanon.sensorsmonitor.sensorUnit.service.SensorUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/sensor-unit")
public class SensorUnitController {

    private final SensorUnitService sensorUnitService;

    @GetMapping
    public ResponseEntity<List<SensorUnit>> getAll() {
        return ResponseEntity.ok(sensorUnitService.getAll());
    }
}
