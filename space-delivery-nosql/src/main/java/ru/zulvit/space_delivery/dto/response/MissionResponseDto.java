package ru.zulvit.space_delivery.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class MissionResponseDto {
    private long id;
    private long rocketId;
    private long cargoId;
    private Date launchDate;
    private Date estimatedArrivalDate;
    private String status;
}
