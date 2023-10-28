package com.antonydanon.sensorsmonitor.sensor.service;

import com.antonydanon.sensorsmonitor.sensor.exception.SensorNotFoundException;
import com.antonydanon.sensorsmonitor.sensor.model.Sensor;
import com.antonydanon.sensorsmonitor.sensor.model.SensorCreateDto;
import com.antonydanon.sensorsmonitor.sensor.model.SensorUpdateDto;
import com.antonydanon.sensorsmonitor.sensor.repository.SensorRepository;
import com.antonydanon.sensorsmonitor.sensorType.service.SensorTypeService;
import com.antonydanon.sensorsmonitor.sensorUnit.service.SensorUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultSensorService implements SensorService {

    private final SensorTypeService sensorTypeService;
    private final SensorUnitService sensorUnitService;
    private final SensorRepository sensorRepository;

    @Override
    public Sensor get(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new SensorNotFoundException("Sensor not found."));
    }

    @Override
    public List<Sensor> getAll() {
        return sensorRepository.findAll();
    }

    @Override
    @Transactional
    public Sensor create(SensorCreateDto dto) {
        Sensor sensor = toSensor(dto);
        return sensorRepository.save(sensor);
    }

    @Override
    @Transactional
    public Sensor update(SensorUpdateDto dto) {
        Sensor sensor = get(dto.getId());
        sensor.setName(dto.getName());
        sensor.setModel(dto.getModel());
        sensor.setSensorUnit(sensorUnitService.findByName(dto.getSensorUnit()));
        sensor.setSensorType(sensorTypeService.findByName(dto.getSensorType()));
        sensor.setRangeFrom(dto.getRangeFrom());
        sensor.setRangeTo(dto.getRangeTo());
        sensor.setDescription(dto.getDescription());
        sensor.setLocation(dto.getLocation());
        return sensorRepository.save(sensor);
    }

    @Override
    public void delete(Long id) {
        sensorRepository.deleteById(id);
    }

    private Sensor toSensor(SensorCreateDto dto) {
        return new Sensor().setName(dto.getName())
                .setModel(dto.getModel())
                .setRangeFrom(dto.getRangeFrom())
                .setRangeTo(dto.getRangeTo())
                .setSensorType(sensorTypeService.findByName(dto.getSensorType()))
                .setSensorUnit(sensorUnitService.findByName(dto.getSensorUnit()))
                .setDescription(dto.getDescription())
                .setLocation(dto.getLocation());
    }
}
