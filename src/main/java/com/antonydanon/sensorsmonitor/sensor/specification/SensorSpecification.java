package com.antonydanon.sensorsmonitor.sensor.specification;

import com.antonydanon.sensorsmonitor.sensor.model.Sensor;
import org.springframework.data.jpa.domain.Specification;

public class SensorSpecification {

    private static final String WILDCARD = "%";

    public static Specification<Sensor> nameLike(String searchTerm) {
        return (root, query, cb) -> cb.like(root.get("name"), searchPattern(searchTerm));
    }

    public static Specification<Sensor> modelLike(String searchTerm) {
        return (root, query, cb) -> cb.like(root.get("model"), searchPattern(searchTerm));
    }

    public static Specification<Sensor> rangeFromLike(String searchTerm) {
        return (root, query, cb) -> cb.like(root.get("rangeFrom").as(String.class), searchPattern(searchTerm));
    }

    public static Specification<Sensor> rangeToLike(String searchTerm) {
        return (root, query, cb) -> cb.like(root.get("rangeTo").as(String.class), searchPattern(searchTerm));
    }

    public static Specification<Sensor> sensorTypeLike(String searchTerm) {
        return (root, query, cb) -> cb.like(root.join("sensorType").get("name"), searchPattern(searchTerm));
    }

    public static Specification<Sensor> sensorUnitLike(String searchTerm) {
        return (root, query, cb) -> cb.like(root.join("sensorUnit").get("name"), searchPattern(searchTerm));
    }

    public static Specification<Sensor> descriptionLike(String searchTerm) {
        return (root, query, cb) -> cb.like(root.get("description"), searchPattern(searchTerm));
    }

    public static Specification<Sensor> locationLike(String searchTerm) {
        return (root, query, cb) -> cb.like(root.get("location"), searchPattern(searchTerm));
    }

    private static String searchPattern(String searchTerm) {
        return WILDCARD + searchTerm + WILDCARD;
    }
}
