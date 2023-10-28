package com.antonydanon.sensorsmonitor.sensorType.repository;

import com.antonydanon.sensorsmonitor.sensorType.model.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {
    Optional<SensorType> findByName(String name);
}
