package com.antonydanon.sensorsmonitor.utils;

public class ValidationUtils {
    public static void validateThatOneValueIsLessThanOther(Integer firstValue, Integer secondValue, String message) {
        if (firstValue != null && secondValue != null) {
            if (firstValue >= secondValue) {
                throw new IllegalArgumentException(message);
            }
        }
    }
}
