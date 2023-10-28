package com.antonydanon.sensorsmonitor.sensorUnit.service;

import com.antonydanon.sensorsmonitor.sensorUnit.exception.SensorUnitNotFoundException;
import com.antonydanon.sensorsmonitor.sensorUnit.model.SensorUnit;
import com.antonydanon.sensorsmonitor.sensorUnit.repository.SensorUnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultSensorUnitService implements SensorUnitService {

    private final SensorUnitRepository sensorUnitRepository;

    @Override
    public List<SensorUnit> getAll() {
        return sensorUnitRepository.findAll();
    }

    @Override
    public SensorUnit findByName(String name) {
        return sensorUnitRepository.findByName(name)
                .orElseThrow(() -> new SensorUnitNotFoundException("Sensor unit not found."));
    }
}
