package com.antonydanon.sensorsmonitor.sensor.controller;

import com.antonydanon.sensorsmonitor.sensor.model.Sensor;
import com.antonydanon.sensorsmonitor.sensor.model.SensorCreateDto;
import com.antonydanon.sensorsmonitor.sensor.model.SensorUpdateDto;
import com.antonydanon.sensorsmonitor.sensor.service.SensorService;
import com.antonydanon.sensorsmonitor.user.model.Role;
import com.antonydanon.sensorsmonitor.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import static com.antonydanon.sensorsmonitor.utils.ValidationUtils.validateThatOneValueIsLessThanOther;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/sensor")
public class SensorController {

    private final SensorService sensorService;

    @GetMapping
    public ResponseEntity<Page<Sensor>> getAllByPage(@RequestParam String searchTerm, @RequestParam int pageNumber) {
        return ResponseEntity.ok(sensorService.getAllBySearchAndPage(searchTerm, pageNumber));
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
    public ResponseEntity<String> create(@Valid @RequestBody SensorCreateDto dto) {
        validateThatOneValueIsLessThanOther(dto.getRangeFrom(), dto.getRangeTo(),
                "Range from value must be less than Range to value.");
        sensorService.create(dto);
        return ResponseEntity.ok("Sensor has been created.");
    }

    @PatchMapping
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<String> update(@Valid @RequestBody SensorUpdateDto dto) {
        sensorService.update(dto);
        return ResponseEntity.ok("Sensor has been updated.");
    }
}
