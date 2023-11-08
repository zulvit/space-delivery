package ru.zulvit.space_delivery.dto.request;

import lombok.Data;

@Data
public class CargoRequestDto {
    private String description;
    private float weight;
    private String purpose;
    private String departureDate;
    private String arrivalDate;
}
