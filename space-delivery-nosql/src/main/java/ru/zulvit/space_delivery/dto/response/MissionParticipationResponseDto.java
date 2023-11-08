package ru.zulvit.space_delivery.dto.response;

import lombok.Data;

@Data
public class MissionParticipationResponseDto {
    private String id;
    private String missionId;
    private String astronautId;
    private String role;
}