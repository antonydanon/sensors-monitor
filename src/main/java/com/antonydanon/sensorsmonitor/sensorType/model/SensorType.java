package com.antonydanon.sensorsmonitor.sensorType.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "sensor_type")
@Data
public class SensorType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
