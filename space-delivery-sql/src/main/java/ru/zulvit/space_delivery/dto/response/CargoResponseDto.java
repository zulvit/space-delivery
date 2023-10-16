package ru.zulvit.space_delivery.dto.response;

import lombok.Data;

@Data
public class CargoResponseDto {
    private long id;
    private String description;
    private float weight;
    private String purpose;
    private String departureDate;
    private String arrivalDate;
}
