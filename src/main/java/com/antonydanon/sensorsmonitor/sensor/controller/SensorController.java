package com.antonydanon.sensorsmonitor.sensor.controller;

import com.antonydanon.sensorsmonitor.sensor.model.Sensor;
import com.antonydanon.sensorsmonitor.sensor.model.SensorCreateDto;
import com.antonydanon.sensorsmonitor.sensor.model.SensorUpdateDto;
import com.antonydanon.sensorsmonitor.sensor.service.SensorService;
import com.antonydanon.sensorsmonitor.user.model.Role;
import com.antonydanon.sensorsmonitor.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/sensor")
public class SensorController {

    private final SensorService sensorService;

    @GetMapping
    public ResponseEntity<List<Sensor>> getAll() {
        return ResponseEntity.ok(sensorService.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<Sensor> get(@PathVariable Long id) {
        return ResponseEntity.ok(sensorService.get(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        sensorService.delete(id);
        return ResponseEntity.ok("Sensor has been deleted.");
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<String> create(@RequestBody SensorCreateDto dto) {
        sensorService.create(dto);
        return ResponseEntity.ok("Sensor has been created.");
    }

    @PatchMapping
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<String> updatePost(@RequestBody SensorUpdateDto dto) {
        sensorService.update(dto);
        return ResponseEntity.ok("Sensor has been updated.");
    }
}
