package com.antonydanon.sensorsmonitor.sensor.repository;

import com.antonydanon.sensorsmonitor.sensor.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SensorRepository extends JpaRepository<Sensor, Long>, JpaSpecificationExecutor<Sensor> {

}
