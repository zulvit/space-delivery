package ru.zulvit.space_delivery.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class MissionResponseDto {
    private String id;
    private String rocketId;
    private String cargoId;
    private Date launchDate;
    private Date estimatedArrivalDate;
    private String status;
}
