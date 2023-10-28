package com.antonydanon.sensorsmonitor.sensor.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SensorCreateDto {
    private String name;
    private String model;
    private Integer rangeFrom;
    private Integer rangeTo;
    private String sensorType;
    private String sensorUnit;
    private String location;
    private String description;
}
