package com.antonydanon.sensorsmonitor.sensor.model;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class SensorUpdateDto {
    @NotNull(message = "should not be empty")
    private Long id;
    @NotBlank(message = "should not be empty")
    @Size(max = 30, message = "should not be more than 30")
    private String name;
    @NotBlank(message = "should not be empty")
    @Size(max = 15, message = "should not be more than 15")
    private String model;
    private Integer rangeFrom;
    private Integer rangeTo;
    @NotBlank(message = "should not be empty")
    private String sensorType;
    @NotBlank(message = "should not be empty")
    private String sensorUnit;
    @Size(max = 40, message = "should not be more than 40")
    private String location;
    @Size(max = 200, message = "should not be more than 200")
    private String description;
}
