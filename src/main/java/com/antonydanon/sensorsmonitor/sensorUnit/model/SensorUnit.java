package com.antonydanon.sensorsmonitor.sensorUnit.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "sensor_unit")
@Data
public class SensorUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
