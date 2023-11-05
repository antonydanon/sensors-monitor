package com.antonydanon.sensorsmonitor.sensorType.service;

import com.antonydanon.sensorsmonitor.sensorType.exception.SensorTypeNotFoundException;
import com.antonydanon.sensorsmonitor.sensorType.model.SensorType;
import com.antonydanon.sensorsmonitor.sensorType.repository.SensorTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultSensorType implements SensorTypeService {

    private final SensorTypeRepository sensorTypeRepository;


    @Override
    public List<SensorType> getAll() {
        return sensorTypeRepository.findAll();
    }

    @Override
    public SensorType getByName(String name) {
        return sensorTypeRepository.findByName(name)
                .orElseThrow(() -> new SensorTypeNotFoundException("Sensor type not found."));
    }
}
