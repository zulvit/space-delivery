package ru.zulvit.space_delivery.dto.request;

import lombok.Data;

@Data
public class RocketRequestDto {
    private long name;
    private String manufacturer;
    private float maxLoad;
    private float speed;
}
