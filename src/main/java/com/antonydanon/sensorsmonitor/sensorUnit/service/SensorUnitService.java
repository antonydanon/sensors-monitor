package com.antonydanon.sensorsmonitor.sensorUnit.service;

import com.antonydanon.sensorsmonitor.sensorUnit.model.SensorUnit;
import java.util.List;

public interface SensorUnitService {

    List<SensorUnit> getAll();

    SensorUnit findByName(String name);
}
