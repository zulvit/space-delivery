package ru.zulvit.space_delivery.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class MissionRequestDto {
    long rocketId;
    long cargoId;
    Date launchdate;
    Date estimatedArrivalDate;
    String status;
}
