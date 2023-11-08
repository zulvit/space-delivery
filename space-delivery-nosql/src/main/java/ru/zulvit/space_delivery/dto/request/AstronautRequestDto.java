package ru.zulvit.space_delivery.dto.request;

import lombok.Data;

@Data
public class AstronautRequestDto {
    private String firstName;
    private String lastName;
    private String nationality;
    private String date;
    private int missionsParticipated;
}
