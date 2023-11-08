package ru.zulvit.space_delivery.dto.request;

import lombok.Data;

@Data
public class AstronautRequestDto {
    String firstName;
    String lastName;
    String nationality;
    String date;
    int missionsParticipated;
}
