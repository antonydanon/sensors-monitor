package com.antonydanon.sensorsmonitor.general.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ValidationExceptionResponse {

    private final List<Violation> violations;
}