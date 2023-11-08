package ru.zulvit.space_delivery.dto.response;

import lombok.Data;
import ru.zulvit.space_delivery.dto.request.MissionParticipationRequestDto;

import java.util.Date;
import java.util.Set;

@Data
public class AstronautResponseDto {
    private String id;
    private String firstName;
    private String lastName;
    private String nationality;
    private Date birthDate;
    private int missionsParticipated;
    private Set<MissionParticipationRequestDto> missionParticipation;
}
