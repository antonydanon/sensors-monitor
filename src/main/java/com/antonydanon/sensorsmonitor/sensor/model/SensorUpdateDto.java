package com.antonydanon.sensorsmonitor.sensor.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class SensorUpdateDto {
    private Long id;
    @NotBlank
    @Max(30)
    private String name;
    @NotBlank
    @Max(15)
    private String model;
    private Integer rangeFrom;
    private Integer rangeTo;
    @NotBlank
    private String sensorType;
    @NotBlank
    private String sensorUnit;
    @Max(40)
    private String location;
    @Max(200)
    private String description;
}
