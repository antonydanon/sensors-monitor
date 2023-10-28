package com.antonydanon.sensorsmonitor.sensor.model;

import com.antonydanon.sensorsmonitor.sensorType.model.SensorType;
import com.antonydanon.sensorsmonitor.sensorUnit.model.SensorUnit;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "sensor")
@Data
@Accessors(chain = true)
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model;
    private Integer rangeFrom;
    private Integer rangeTo;
    @ManyToOne
    @JoinColumn(name="type_id")
    private SensorType sensorType;
    @ManyToOne
    @JoinColumn(name="unit_id")
    private SensorUnit sensorUnit;

    private String location;
    private String description;
}
