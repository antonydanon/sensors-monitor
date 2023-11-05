package com.antonydanon.sensorsmonitor.sensor.service;

import com.antonydanon.sensorsmonitor.sensor.exception.SensorNotFoundException;
import com.antonydanon.sensorsmonitor.sensor.model.Sensor;
import com.antonydanon.sensorsmonitor.sensor.model.SensorCreateDto;
import com.antonydanon.sensorsmonitor.sensor.model.SensorUpdateDto;
import com.antonydanon.sensorsmonitor.sensor.repository.SensorRepository;
import com.antonydanon.sensorsmonitor.sensorType.service.SensorTypeService;
import com.antonydanon.sensorsmonitor.sensorUnit.service.SensorUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.antonydanon.sensorsmonitor.sensor.specification.SensorSpecification.*;
import static org.apache.logging.log4j.util.Strings.isNotBlank;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
@RequiredArgsConstructor
public class DefaultSensorService implements SensorService {

    private static final int NUMBER_OF_SENSORS_PER_PAGE = 4;

    private final SensorTypeService sensorTypeService;
    private final SensorUnitService sensorUnitService;
    private final SensorRepository sensorRepository;

    @Override
    public Sensor getSensor(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new SensorNotFoundException("Sensor not found."));
    }

    @Override
    public Page<Sensor> getAllBySearchAndPage(String searchTerm, int pageNumber) {
        if (isNotBlank(searchTerm)) {
            return sensorRepository
                    .findAll(where(nameLike(searchTerm)
                            .or(modelLike(searchTerm))
                            .or(rangeFromLike(searchTerm))
                            .or(rangeToLike(searchTerm))
                            .or(sensorTypeLike(searchTerm))
                            .or(sensorUnitLike(searchTerm))
                            .or(locationLike(searchTerm))
                            .or(descriptionLike(searchTerm))),
                            PageRequest.of(pageNumber, NUMBER_OF_SENSORS_PER_PAGE));
        } else {
            return sensorRepository
                    .findAll(PageRequest.of(pageNumber, NUMBER_OF_SENSORS_PER_PAGE));
        }
    }

    @Override
    @Transactional
    public Sensor createSensor(SensorCreateDto dto) {
        Sensor sensor = toSensor(dto);
        return sensorRepository.save(sensor);
    }

    @Override
    @Transactional
    public Sensor updateSensor(SensorUpdateDto dto) {
        Sensor sensor = getSensor(dto.getId());
        return sensorRepository.save(updatedSensor(sensor, dto));
    }

    @Override
    public void deleteSensor(Long id) {
        sensorRepository.deleteById(id);
    }

    private Sensor toSensor(SensorCreateDto dto) {
        return new Sensor().setName(dto.getName())
                .setModel(dto.getModel())
                .setRangeFrom(dto.getRangeFrom())
                .setRangeTo(dto.getRangeTo())
                .setSensorType(sensorTypeService.getByName(dto.getSensorType()))
                .setSensorUnit(sensorUnitService.findByName(dto.getSensorUnit()))
                .setDescription(dto.getDescription())
                .setLocation(dto.getLocation());
    }

    private Sensor updatedSensor(Sensor sensor, SensorUpdateDto dto) {
        sensor.setName(dto.getName());
        sensor.setModel(dto.getModel());
        sensor.setSensorUnit(sensorUnitService.findByName(dto.getSensorUnit()));
        sensor.setSensorType(sensorTypeService.getByName(dto.getSensorType()));
        sensor.setRangeFrom(dto.getRangeFrom());
        sensor.setRangeTo(dto.getRangeTo());
        sensor.setDescription(dto.getDescription());
        sensor.setLocation(dto.getLocation());
        return sensor;
    }
}
