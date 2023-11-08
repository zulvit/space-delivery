package ru.zulvit.space_delivery.dto.request;

import lombok.Data;

@Data
public class MissionParticipationRequestDto {
    private String missionId;
    private String astronautId;
    private String role;
}
