package ru.zulvit.space_delivery.dto.request;

import lombok.Data;

@Data
public class CargoRequestDto {
    String description;
    float weight;
    String purpose;
    String departureDate;
    String arrivalDate;
}
