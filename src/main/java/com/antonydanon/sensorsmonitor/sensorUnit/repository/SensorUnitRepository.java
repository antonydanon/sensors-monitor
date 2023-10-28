package com.antonydanon.sensorsmonitor.sensorUnit.repository;

import com.antonydanon.sensorsmonitor.sensorUnit.model.SensorUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SensorUnitRepository extends JpaRepository<SensorUnit, Long> {

    Optional<SensorUnit> findByName(String name);
}
