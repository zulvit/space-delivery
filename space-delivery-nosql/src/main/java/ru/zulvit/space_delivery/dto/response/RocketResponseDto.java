package ru.zulvit.space_delivery.dto.response;

import lombok.Data;

@Data
public class RocketResponseDto {
    private long id;
    private String name;
    private String manufacturer;
    private float maxLoad;
    private float speed;
}
