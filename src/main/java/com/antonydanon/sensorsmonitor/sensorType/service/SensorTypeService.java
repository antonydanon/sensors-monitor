package com.antonydanon.sensorsmonitor.sensorType.service;

import com.antonydanon.sensorsmonitor.sensorType.model.SensorType;

import java.util.List;

public interface SensorTypeService {

    List<SensorType> getAll();

    SensorType getByName(String name);
}
