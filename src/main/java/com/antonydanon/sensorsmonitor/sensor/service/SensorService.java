package com.antonydanon.sensorsmonitor.sensor.service;

import com.antonydanon.sensorsmonitor.sensor.model.Sensor;
import com.antonydanon.sensorsmonitor.sensor.model.SensorCreateDto;
import com.antonydanon.sensorsmonitor.sensor.model.SensorUpdateDto;

import java.util.List;

public interface SensorService {

    Sensor get(Long id);
    List<Sensor> getAll();

    Sensor create(SensorCreateDto dto);

    Sensor update(SensorUpdateDto dto);

    void delete(Long id);
}
