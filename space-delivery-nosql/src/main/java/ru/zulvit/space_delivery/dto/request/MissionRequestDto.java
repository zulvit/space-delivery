package ru.zulvit.space_delivery.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class MissionRequestDto {
    private String rocketId;
    private String cargoId;
    private Date launchdate;
    private Date estimatedArrivalDate;
    private String status;
}
