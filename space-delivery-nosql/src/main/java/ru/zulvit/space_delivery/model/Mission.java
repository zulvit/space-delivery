package ru.zulvit.space_delivery.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "missions")
@Data
public class Mission {
    @Id
    private String id;
    private Rocket rocket;
    private Cargo cargo;
    private Date launchDate;
    private Date estimatedArrivalDate;
    private Date actualArrivalDate;
    private String status;
    private List<MissionParticipation> missionParticipations;
}

