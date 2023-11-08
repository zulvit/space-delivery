package ru.zulvit.space_delivery.dto.request;

import lombok.Data;

@Data
public class RocketRequestDto {
    long name;
    String manufacturer;
    float maxLoad;
    float speed;
}
