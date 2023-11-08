package ru.zulvit.space_delivery.dto.response;

import lombok.Data;

@Data
public class MissionParticipationResponseDto {
    private long id;
    private long missionId;
    private long astronautId;
    private String role;
}