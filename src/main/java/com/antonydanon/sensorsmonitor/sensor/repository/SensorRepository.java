package com.antonydanon.sensorsmonitor.sensor.repository;

import com.antonydanon.sensorsmonitor.sensor.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
