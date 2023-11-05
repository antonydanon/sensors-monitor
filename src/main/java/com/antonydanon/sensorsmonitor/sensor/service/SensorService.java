package com.antonydanon.sensorsmonitor.sensor.service;

import com.antonydanon.sensorsmonitor.sensor.model.Sensor;
import com.antonydanon.sensorsmonitor.sensor.model.SensorCreateDto;
import com.antonydanon.sensorsmonitor.sensor.model.SensorUpdateDto;
import org.springframework.data.domain.Page;


public interface SensorService {

    Sensor getSensor(Long id);
    Page<Sensor> getAllBySearchAndPage(String searchTerm, int pageNumber);

    Sensor createSensor(SensorCreateDto dto);

    Sensor updateSensor(SensorUpdateDto dto);

    void deleteSensor(Long id);
}
